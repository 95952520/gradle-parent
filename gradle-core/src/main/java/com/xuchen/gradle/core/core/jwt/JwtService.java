package com.xuchen.gradle.core.core.jwt;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xuchen.gradle.core.model.ex.AuthException;
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
    private static JWTVerifier verifier;

    @PostConstruct
    public void init(){
        ALGORITHM = Algorithm.HMAC256(secret);
        verifier = JWT.require(ALGORITHM).build();
    }

    public String generateToken(User user){
        user.setPassword(null);
        DateTime expireTime = DateUtil.offsetMinute(DateUtil.date(), expiresMin);
        String token = JWT.create()
                .withClaim("customer_user",JSONUtil.toJsonStr(user))
                .withIssuer("gradleServer")
                .withSubject("gradleSubject")
                .withIssuedAt(DateUtil.date())
                //过期时间
                .withExpiresAt(expireTime)
                .sign(ALGORITHM);
        return token;
    }

    public User parseToken(String token){
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(token);
        }catch (TokenExpiredException tokenExpiredException){
            throw new AuthException(4000, "token过期");
        }catch (Exception e){
            throw new AuthException(4001, "token解析失败");
        }
        return JSONUtil.toBean(jwt.getClaim("customer_user").asString(),User.class);
    }
}
