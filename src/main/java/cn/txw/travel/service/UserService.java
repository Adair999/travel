package cn.txw.travel.service;

import cn.txw.travel.domain.User;
@SuppressWarnings("all")  //警告注解
public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);
    /**
     * 激活用户
     * @param code
     * @return
     */
    boolean active(String code);
    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);
}