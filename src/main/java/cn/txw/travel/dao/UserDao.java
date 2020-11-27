package cn.txw.travel.dao;

import cn.txw.travel.domain.Seller;
import cn.txw.travel.domain.User;

import java.util.List;

/**
 *定义UserDao接口
 */
@SuppressWarnings("all")  //警告注解
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);
    /**
     * 用户保存
     * @param user
     */
    public void save(User user);
    /**
     * 根据激活码查询用户对象
     * @param code
     * @return
     */
    User findByCode(String code);
    /**
     *修改指定用户激活状态
     * @param user
     */
    void updateStatus(User user);
    /**
     *根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}