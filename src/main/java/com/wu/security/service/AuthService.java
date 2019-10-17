package com.wu.security.service;

import com.wu.security.comm.util.R;
import com.wu.security.entity.User;

/**
 * 登录注册接口
 *
 * @author Qwu
 */
public interface AuthService {
    /**
     * 注册
     * @param userToAdd
     * @return
     */
    R register(User userToAdd);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);
}
