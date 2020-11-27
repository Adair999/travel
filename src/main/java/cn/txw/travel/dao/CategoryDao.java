package cn.txw.travel.dao;

import cn.txw.travel.domain.Category;

import java.util.List;
/**
 * 定义CategoryDao接口
 */
@SuppressWarnings("all")  //警告注解
public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();
}