package cn.txw.travel.dao.impl;

import cn.txw.travel.dao.RouteImgDao;
import cn.txw.travel.domain.RouteImg;
import cn.txw.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 *图片的查询
 */
import java.util.List;
public class RouteImgDaoImpl implements RouteImgDao {
    //声明template业务对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查找route的id查询图片
     * @param rid
     * @return
     */
    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid =? ";
        return template.query(sql,new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);
    }
}