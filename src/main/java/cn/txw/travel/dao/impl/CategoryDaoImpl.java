package cn.txw.travel.dao.impl;

import cn.txw.travel.dao.CategoryDao;
import cn.txw.travel.domain.Category;
import cn.txw.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
/**
 * 定义CategoryDaoImpl类实现CategoryDao接口
 */
public class CategoryDaoImpl implements CategoryDao {
    //声明template业务对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category ";
        return template.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}