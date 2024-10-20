package com.jlf.music.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import java.util.Calendar;

public class JwtUtil {
    // 定义一个静态常量，存储用于签名的密钥
    public static final String SECRET = "ASD!@#F^%A";

    // 创建一个 token 的方法，接收用户 ID 和用户名作为参数
    public static String createToken(Long userId, String username) {
        // 检查用户 ID 是否为空，如果为空则抛出异常
        if (userId == null) {
            throw new IllegalArgumentException("userId 不能为空");
        }

        // 创建一个 Calendar 实例，用于设置 token 的过期时间
        Calendar expires = Calendar.getInstance();
        // 设置过期时间为当前时间加上 10 小时
        expires.add(Calendar.HOUR, 10);

        // 使用 JWT 库创建 token
        String jwtToken = JWT.create()
                // 在 token 的 Payload 中添加用户 ID
                .withClaim("userId", String.valueOf(userId))
                // 在 token 的 Payload 中添加用户名
                .withClaim("username", username)
                // 设置 token 的过期时间
                .withExpiresAt(expires.getTime())
                // 使用 HMAC256 算法和 SECRET 进行签名
                .sign(Algorithm.HMAC256(SECRET));

        // 返回生成的 token
        return jwtToken;
    }

    // 解析 token 的方法，接收 token 字符串作为参数
    public static DecodedJWT parseToken(String token) {
        // 检查 token 是否为空，如果为空则抛出异常
        if (token == null) {
            throw new RuntimeException("token为空");
        }

        // 创建一个 JWT 验证器，使用 HMAC256 算法和 SECRET 进行验证
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        // 验证 token，并返回解码后的 JWT 对象
        return jwtVerifier.verify(token);
    }
}
