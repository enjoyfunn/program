package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CartItem;
import com.ruoyi.system.domain.Course;

/**
 * 购物车商品Service接口
 * 
 * @author ruoyi
 * @date 2025-02-14
 */
public interface ICartItemService 
{
    /**
     * 查询购物车商品
     * 
     * @param id 购物车商品主键
     * @return 购物车商品
     */
    public CartItem selectCartItemById(Long id);

    public CartItem selectCartItemListByIdAndUser(Long id , Long userId);

    /**
     * 查询购物车商品列表
     * 
     * @param cartItem 购物车商品
     * @return 购物车商品集合
     */
    public List<CartItem> selectCartItemList(CartItem cartItem);

    public List<CartItem> selectCartItemListById(Long userId);

    public  int deleteCartItemByIdAndUser(Long id, Long userId);

    /**
     * 新增购物车商品
     * 
     * @param cartItem 购物车商品
     * @return 结果
     */
    public int insertCartItem(CartItem cartItem);

    public CartItem selectCartItem(Integer courseId, Long userId );

    //商品添加购物车计数
     long   selectCartItemCount(Long userId);

    /**
     * 修改购物车商品
     * 
     * @param cartItem 购物车商品
     * @return 结果
     */
    public int updateCartItem(CartItem cartItem);

    /**
     * 批量删除购物车商品
     * 
     * @param ids 需要删除的购物车商品主键集合
     * @return 结果
     */
    public int deleteCartItemByIds(Long[] ids);

    /**
     * 删除购物车商品信息
     * 
     * @param id 购物车商品主键
     * @return 结果
     */
    public int deleteCartItemById(Long id);
}
