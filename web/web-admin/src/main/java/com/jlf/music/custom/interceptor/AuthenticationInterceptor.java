package com.jlf.music.custom.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.jlf.music.common.login.LoginUser;
import com.jlf.music.common.login.LoginUserHolder;
import com.jlf.music.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    /**
     * 请求处理之前执行该方法 用于身份验证和用户信息的保存
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取token
        String token = request.getHeader("access-token");
        // 解析token
        DecodedJWT decodedJWT = JwtUtil.parseToken(token);
        Long userId = Long.valueOf(decodedJWT.getClaim("userId").asString());
        String username = decodedJWT.getClaim("username").asString();
        LoginUserHolder.setLoginUser(new LoginUser(userId, username));
        return true;
    }

    /**
     * 在请求处理完成后执行 用于清理工作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        LoginUserHolder.clear();
    }
}
