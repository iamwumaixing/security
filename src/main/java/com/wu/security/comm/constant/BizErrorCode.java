package com.wu.security.comm.constant;

import lombok.Getter;

/**
 * 系统错误码
 *
 * @author Qwu
 */
public enum BizErrorCode {
    /***/
    SYS_ERROR(1,"系统错误"),

    DATABASE_ERROR(300,"数据库连接错误"),

    USER_REPEAT(1001,"用户已存在");

    @Getter
    private int code;
    @Getter
    private String msg;

    BizErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
