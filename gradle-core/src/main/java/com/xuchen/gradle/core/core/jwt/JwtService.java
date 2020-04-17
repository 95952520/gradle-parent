package com.xuchen.gradle.core.core.jwt;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xuchen.gradle.core.mysql.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Edwin
 * @date 2020/4/17
 */
@Service
public class JwtService {

    @Value("${jwt.secret:mySecret}")
    String secret;
    @Value("${jwt.expiresMin:120}")
    int expiresMin;

    private static Algorithm ALGORITHM;

    @PostConstruct
    public void init(){
        ALGORITHM = Algorithm.HMAC256(secret);
    }

    public String generateToken(User user){
        DateTime expireTime = DateUtil.offsetMinute(DateUtil.date(), expiresMin);
        String token = JWT.create()
                .withClaim("id",user.getId())
                .withClaim("nickName",user.getNickName())
                .withIssuer("gradleServer")
                .withSubject("gradleSubject")
                .withIssuedAt(DateUtil.date())
                //过期时间
                .withExpiresAt(expireTime)
                .sign(ALGORITHM);
        return token;
    }

    public User parseToken(String token){
        JWTVerifier verifier = JWT.require(ALGORITHM)
                .build();
        DecodedJWT jwt = verifier.verify(token);
        System.out.println(JSONUtil.toJsonPrettyStr(jwt));
        System.out.println(jwt);
        System.out.println(jwt.getClaim("id"));
        System.out.println(jwt.getClaim("nickName"));
        System.out.println(jwt.getHeaderClaim("id"));
        System.out.println(jwt.getHeaderClaim("nickName"));
        System.out.println(DateUtil.date(jwt.getExpiresAt()));
        return null;
    }
}
