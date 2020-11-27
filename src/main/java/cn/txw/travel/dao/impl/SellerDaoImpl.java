package cn.txw.travel.dao.impl;

import cn.txw.travel.dao.SellerDao;
import cn.txw.travel.domain.Seller;
import cn.txw.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * 卖家的实现类
 */
public class SellerDaoImpl implements SellerDao {
    //声明template业务对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Seller findById(int id) {
        String sql = "select * from tab_seller where sid =? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Seller>(Seller.class),id);
    }
}