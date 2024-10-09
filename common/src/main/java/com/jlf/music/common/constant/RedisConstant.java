package com.jlf.music.common.constant;


public class RedisConstant {
    // 管理员端 key的前缀
    public static final String ADMIN_LOGIN_PREFIX = "admin:login";
    // 管理员端 验证码有效时长
    public static final Integer ADMIN_LOGIN_CAPTCHA_TTL_SEC = 300;
    public static final String USER_LOGIN_PREFIX = "user:login";
    public static final Integer USER_LOGIN_CODE_RESEND_TTL_SEC = 60;
    public static final Integer USER_LOGIN_CODE_TTL_SEC = 60 * 10;
}
