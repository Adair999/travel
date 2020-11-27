package cn.txw.travel.web.servlet;

import cn.txw.travel.domain.PageBean;
import cn.txw.travel.domain.Route;
import cn.txw.travel.domain.User;
import cn.txw.travel.service.FavoriteService;
import cn.txw.travel.service.RouteService;
import cn.txw.travel.service.impl.FavoriteServiceImpl;
import cn.txw.travel.service.impl.RouteServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@SuppressWarnings("all")  //警告注解
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service = new RouteServiceImpl();
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();
    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String rname = request.getParameter("rname");   //接受rname 线路名称
        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");   //解决乱码的问题
        int cid = 0;  //类别id
        //处理参数
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            //cid = Integer.parseInt(cidStr);
            cid = 5;
        }
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }
        //调用service 查询PageBean对象
        PageBean<Route> pb = service.pageQuery(cid, currentPage, pageSize, rname);
        //将pageBean对象序列化为json
        writeValue(pb, response);
    }
    /**
     * 根据id查询一个旅游线路的详细信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收id
        String rid = request.getParameter("rid");
        //调用Service查询route对象
        Route route = service.findOne(rid);
        //转为json写回客户端
        writeValue(route, response);
    }
    /**
     * 判断当前登录用户是否收藏过该线路
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路的rid
        String rid = request.getParameter("rid");
        //获取当前登录的用户 user
        User user = (User) request.getSession().getAttribute("user");
        int uid; //定义用户的id
        //判断用户登录
        if (user == null){
            //用户尚未登录
            uid =0;
        }else {
        //用户已经登录
        uid = user.getUid();
        }
        //调用FavoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);
        //将flag写回客户端
        writeValue(flag,response);
    }
    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取线路的rid
        String rid = request.getParameter("rid");
        //获取当前登录的用户 user
        User user = (User) request.getSession().getAttribute("user");
        int uid; //定义用户的id
        //判断用户登录
        if (user == null){
            //用户尚未登录
            return;
        }else {
            //用户已经登录
            uid = user.getUid();
        }
        //调用Service进行添加
        favoriteService.add(rid,uid);
    }
}