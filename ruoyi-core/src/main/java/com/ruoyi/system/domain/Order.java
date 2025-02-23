package com.ruoyi.system.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单列表对象 db_order
 * 
 * @author ruoyi
 * @date 2025-02-23
 */
public class Order extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String id;

    /**  */
    @Excel(name = "")
    private Long uid;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /**  */
    @Excel(name = "")
    private Long price;

    /**  */
    @Excel(name = "")
    private String name;

    /**  */
    @Excel(name = "")
    private String company;

    /**  */
    @Excel(name = "")
    private String country;

    /**  */
    @Excel(name = "")
    private String city;

    /**  */
    @Excel(name = "")
    private String steet1;

    /**  */
    @Excel(name = "")
    private String steet2;

    /**  */
    @Excel(name = "")
    private String postal;

    /**  */
    @Excel(name = "")
    private String phone;

    /**  */
    @Excel(name = "")
    private String email;

    /**  */
    @Excel(name = "")
    private String note;

    /** 订单商品列表信息 */
    private List<OrderItem> orderItemList;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setSteet1(String steet1) 
    {
        this.steet1 = steet1;
    }

    public String getSteet1() 
    {
        return steet1;
    }
    public void setSteet2(String steet2) 
    {
        this.steet2 = steet2;
    }

    public String getSteet2() 
    {
        return steet2;
    }
    public void setPostal(String postal) 
    {
        this.postal = postal;
    }

    public String getPostal() 
    {
        return postal;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }

    public List<OrderItem> getOrderItemList()
    {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList)
    {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("time", getTime())
            .append("price", getPrice())
            .append("name", getName())
            .append("company", getCompany())
            .append("country", getCountry())
            .append("city", getCity())
            .append("steet1", getSteet1())
            .append("steet2", getSteet2())
            .append("postal", getPostal())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("note", getNote())
            .append("orderItemList", getOrderItemList())
            .toString();
    }
}
