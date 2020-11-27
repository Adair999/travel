package cn.txw.travel.dao;

import cn.txw.travel.domain.Seller;
/**
 *卖家的接口
 */
public interface SellerDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Seller findById(int id);
}