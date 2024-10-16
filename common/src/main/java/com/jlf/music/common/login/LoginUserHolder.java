package com.jlf.music.common.login;

/**
 * 存储当前线程的用户登录信息
 */
public class LoginUserHolder {
    public static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();
    public static void setLoginUser(LoginUser user) {
        threadLocal.set(user);
    }
    public static LoginUser getLoginUser() {
        return threadLocal.get();
    }
    public static void clear() {
        threadLocal.remove();
    }
}
