package com.wu.security.comm;

/**
 * 配置常量
 * @author Qwu
 */
public class Const {
    /** 5天(以毫秒ms计) */
    public static final long EXPIRATION_TIME = 432_000_000;
    /** JWT密钥 */
    public static final String SECRET = "JimmyCool";
    /** 请求头Token Key */
    public static final String HEADER_STRING = "Authorization";
    /** token前缀 */
    public static final String TOKEN_PREFIX = "Bearer";
}
