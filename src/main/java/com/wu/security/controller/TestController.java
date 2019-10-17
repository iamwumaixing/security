package com.wu.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限测试Controller
 *
 * @author Qwu
 */
@RestController
public class TestController {

    /**
     * 测试普通权限
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    @GetMapping("normal/test")
    public String test1() {
        return "ROLE_NORMAL /normal/test接口调用成功！";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("admin/test")
    public String test2() {
        return "ROLE_ADMIN /normal/test接口调用成功！";
    }


}
