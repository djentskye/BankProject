package com.hibernate.security.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hibernate.entity.User;
import java.util.Map;

public class JwtDecodeToken {

    public static User decodeUserJwt(String token) {
        User u = new User();
        try {
            DecodedJWT jwt = JWT.decode(token);

            Map<String, Claim> claimMap = jwt.getClaims();

            String a = claimMap.get("username").asString();
            int b = claimMap.get("passnum").asInt();

            u.setUserName(a);
            u.setPassNum(b);
        } catch (JWTDecodeException exception) {
            System.out.println(exception);
        }
        return u;
    }
}
