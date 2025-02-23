package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Order;
import com.ruoyi.system.domain.OrderItem;

/**
 * 订单列表Mapper接口
 * 
 * @author ruoyi
 * @date 2025-02-23
 */
public interface OrderMapper 
{
    /**
     * 查询订单列表
     * 
     * @param id 订单列表主键
     * @return 订单列表
     */
    public Order selectOrderById(String id);

    /**
     * 查询订单列表列表
     * 
     * @param order 订单列表
     * @return 订单列表集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 新增订单列表
     * 
     * @param order 订单列表
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改订单列表
     * 
     * @param order 订单列表
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 删除订单列表
     * 
     * @param id 订单列表主键
     * @return 结果
     */
    public int deleteOrderById(String id);

    /**
     * 批量删除订单列表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderByIds(String[] ids);

    /**
     * 批量删除订单商品列表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderItemByOrderIds(String[] ids);
    
    /**
     * 批量新增订单商品列表
     * 
     * @param orderItemList 订单商品列表列表
     * @return 结果
     */
    public int batchOrderItem(List<OrderItem> orderItemList);
    

    /**
     * 通过订单列表主键删除订单商品列表信息
     * 
     * @param id 订单列表ID
     * @return 结果
     */
    public int deleteOrderItemByOrderId(String id);
}
