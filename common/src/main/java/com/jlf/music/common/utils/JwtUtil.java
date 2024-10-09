package com.jlf.music.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    public static final String SECRET = "ASD!@#F^%A";
    // 创建token
    public static String createToken(Long userId, String username) {
//        HashMap<String, Object> headers = new HashMap<>();
        // 过期时间，60s
        Calendar expires = Calendar.getInstance();
        expires.add(Calendar.SECOND, 600000);

        String jwtToken = JWT.create()
                // 第一部分Header
//                .withHeader(headers)
                // 第二部分Payload
                .withClaim("userId", userId)
                .withClaim("userName", username)
                .withExpiresAt(expires.getTime())
                // 第三部分Signature
                .sign(Algorithm.HMAC256(SECRET));

        return jwtToken;
    }

    // 解析token
    public static void parseToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT verify = jwtVerifier.verify(token);
    }

    public static void main(String[] args) {
        String token = createToken(6L, "exampleUser");
        System.out.println(token);

    }
}
