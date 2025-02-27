package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单商品列表对象 db_order_item
 *
 * @author ruoyi
 * @date 2025-02-27
 */
public class OrderItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单商品ID */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private Long orderId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String title;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Double price;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long count;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setCount(Long count)
    {
        this.count = count;
    }

    public Long getCount()
    {
        return count;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderId", getOrderId())
                .append("title", getTitle())
                .append("price", getPrice())
                .append("count", getCount())
                .toString();
    }
}
