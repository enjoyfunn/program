package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.CartItem;
import com.ruoyi.system.domain.OrderItem;
import com.ruoyi.system.service.ICartItemService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Order;
import com.ruoyi.system.service.IOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单列表Controller
 * 
 * @author ruoyi
 * @date 2025-02-24
 */
@RestController
@RequestMapping("/system/order")
public class OrderController extends BaseController
{
    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICartItemService cartItemService;

    /**
     * 查询订单列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(Order order)
    {
        startPage();
        List<Order> list = orderService.selectOrderList(order);
        return getDataTable(list);
    }

    /**
     * 导出订单列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "订单列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Order order)
    {
        List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        util.exportExcel(response, list, "订单列表数据");
    }

    /**
     * 获取订单列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderService.selectOrderById(id));
    }

    /**
     * 新增订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "订单列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Order order)
    {
        return toAjax(orderService.insertOrder(order));
    }

    /**
     * 修改订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "订单列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Order order)
    {
        return toAjax(orderService.updateOrder(order));
    }

    /**
     * 删除订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "订单列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderService.deleteOrderByIds(ids));
    }

    @PostMapping("/create")
    public AjaxResult createUserOrder(@RequestBody Order order) {
        List<CartItem> items = cartItemService.selectCartItemListById(SecurityUtils.getUserId());

        // Ensure CartItem prices are valid before creating OrderItem
        if (items.stream().anyMatch(cartItem -> cartItem.getPrice() == null)) {
            throw new IllegalArgumentException("Cart contains items with invalid/null prices");
        }

        List<OrderItem> orderItemList = items.stream()
                .map(item -> {
                    OrderItem orderItem = new OrderItem();
                    BeanUtils.copyProperties(item, orderItem, "id");
                    return orderItem;
                })
                .toList();

        // Safely calculate totalPrice with null checks (defensive programming)
        Long totalPrice = orderItemList.stream()
                .map(item -> {
                    Double price = item.getPrice();
                    Long count = item.getCount();
                    return (price != null && count != null) ? count * price.longValue() : 0L;
                })
                .reduce(Long::sum)
                .orElse(0L);

        order.setUid(SecurityUtils.getUserId());
        order.setTime(new Date());
        order.setPrice(totalPrice.doubleValue());
        order.setOrderItemList(orderItemList);

        return toAjax(orderService.insertOrder(order));
    }
}
