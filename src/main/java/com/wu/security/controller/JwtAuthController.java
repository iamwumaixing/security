package com.wu.security.controller;

import com.wu.security.comm.util.R;
import com.wu.security.entity.User;
import com.wu.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

/**
 * 登录注册Controller
 *
 * @author Qwu
 */
@RestController
@RequestMapping("authentication")
public class JwtAuthController {

    @Autowired
    private AuthService authService;

    /**
     * 注册接口
     * @param addUser 用户实体
     * @return user
     * @throws AuthenticationException
     */
    @PostMapping("register")
    public R register(@RequestBody User addUser) throws AuthenticationException {
        return authService.register(addUser);
    }

    /**
     * 登录接口
     * @param username 账号
     * @param password 密码
     * @return token
     * @throws AuthenticationException
     */
    @PostMapping("login")
    public String login(String username,String password) throws AuthenticationException {
        return authService.login(username,password);
    }
}
