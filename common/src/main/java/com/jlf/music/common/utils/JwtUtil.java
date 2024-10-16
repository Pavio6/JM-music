package com.jlf.music.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Calendar;


public class JwtUtil {
    public static final String SECRET = "ASD!@#F^%A";
    // 创建token
    public static String createToken(Long userId, String username) {
        if (userId == null) {
            throw new IllegalArgumentException("userId 不能为空");
        }
        // 过期时间
        Calendar expires = Calendar.getInstance();
        expires.add(Calendar.HOUR, 10);

        String jwtToken = JWT.create()
                // Payload
                .withClaim("userId", String.valueOf(userId))
                .withClaim("username", username)
                .withExpiresAt(expires.getTime())
                // Signature
                .sign(Algorithm.HMAC256(SECRET));

        return jwtToken;
    }

    // 解析token
    public static DecodedJWT parseToken(String token) {
        if (token == null) {
            throw new RuntimeException("token为空");
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        return jwtVerifier.verify(token);

    }

}
