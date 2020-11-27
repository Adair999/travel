package cn.txw.travel.service;

import cn.txw.travel.domain.PageBean;
import cn.txw.travel.domain.Route;
/**
 * 线路Service
 */
@SuppressWarnings("all")  //警告注解
public interface RouteService {
    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize, String rname);
    /**
     * 根据rid查询
     * @param rid
     * @return
     */
    public Route findOne(String rid) ;
}