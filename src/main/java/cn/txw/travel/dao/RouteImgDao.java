package cn.txw.travel.dao;

import cn.txw.travel.domain.RouteImg;
import java.util.List;
/**
 *
 */
public interface RouteImgDao {
    /**
     * 查找route的id查询图片
     * @param rid
     * @return
     */
    List<RouteImg> findByRid(int rid);
}
