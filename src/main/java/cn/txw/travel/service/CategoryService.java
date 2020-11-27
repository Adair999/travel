package cn.txw.travel.service;

import cn.txw.travel.domain.Category;
import java.util.List;
/**
 * 定义CategoryService接口
 */
@SuppressWarnings("all")  //警告注解
public interface CategoryService {
    /**
     * 查询所有分页数据
     * @return
     */
    public List<Category> findAll();
}