package cn.txw.travel.service.impl;

import cn.txw.travel.dao.RouteDao;
import cn.txw.travel.dao.RouteImgDao;
import cn.txw.travel.dao.SellerDao;
import cn.txw.travel.dao.impl.*;
import cn.txw.travel.domain.PageBean;
import cn.txw.travel.domain.Route;
import cn.txw.travel.domain.RouteImg;
import cn.txw.travel.domain.Seller;
import cn.txw.travel.service.RouteService;
import cn.txw.travel.dao.FavoriteDao;
import cn.txw.travel.dao.impl.FavoriteDaoImpl;
import java.util.List;
/**
 * 定义RouteServiceImpl实现RouteService接口
 */
@SuppressWarnings("all")  //警告注解
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao =  new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
   private  FavoriteDao favoriteDao = new FavoriteDaoImpl();
    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;//开始的记录数
        List<Route> list = routeDao.findByPage(cid,start,pageSize,rname);
        pb.setList(list);
        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);
        return pb;
    }
    /**
     * 根据rid查询分页
     * @param rid
     * @return
     */
    @Override
    public Route findOne(String rid) {
        //根据id去route表中查询route对象
        Route route = routeDao.findOne(Integer.parseInt(rid));
        //根据route的id查询图片的信息
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        //将集合设置到route对象中
        route.setRouteImgList(routeImgList);
        //根据route的sid查询卖家的信息
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);
        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);
        return route;
    }
}