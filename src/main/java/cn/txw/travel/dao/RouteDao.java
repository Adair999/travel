package cn.txw.travel.dao;

import cn.txw.travel.domain.Route;
import java.util.List;
/**
 * 定义RouteDao接口
 */
@SuppressWarnings("all")  //警告注解
public interface RouteDao {
    /**
     * 根据cid查询总记录数
     * @param cid
     * @return
     */
    public int findTotalCount(int cid,String rname);
    /**
     * 根据cid，start,pageSize,rname查询当前页的数据集合
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid , int start , int pageSize,String rname);
    /**
     * 根据 rid查询当前页的数据集合
     * @param rid
     * @return
     */
   public Route findOne(int rid);
}