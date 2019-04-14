package com.each.bookserver.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
/**
 * @ProjectName: bookserver
 * @Package: com.each.bookserver.util
 * @Description: 用户登陆生成token
 * @Author: zhangxu
 * @CreateDate: 2019/4/12 14:11
 * @UpdateUser: zhangxu
 * @UpdateDate: 2019/4/12 14:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2019
 */
public class JwtUtil {
    @Value("${jwt.secret}")
    private static String secret;

    private static final String SIGNING_KEY = "DEMO";


    public static Claims getClaim(String token){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SIGNING_KEY)
                    .parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }

    public static String setClaim(String subject,boolean expired,int expiration){
        if (expired){
            return Jwts.builder()
                    .setSubject(subject)
                    .setExpiration(new Date(System.currentTimeMillis() + expiration))
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                    .compact();
        }else {
            return Jwts.builder()
                    .setSubject(subject)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                    .compact();
        }
    }
}
