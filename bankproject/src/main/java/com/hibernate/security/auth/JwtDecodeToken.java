package com.hibernate.security.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hibernate.entity.User;

public class JwtDecodeToken {

    public static User decodeUserJwt(String token) {
        User u = null;
        try {
            DecodedJWT jwt = JWT.decode(token);
            String a = String.valueOf(jwt.getClaim("first_name"));
            String b = String.valueOf(jwt.getClaim("last_name"));
            System.out.println(a);
            System.out.println(b);

            u.setFirstName(a);
        } catch (JWTDecodeException exception) {
            System.out.println(exception);
        }
        return u;
    }
}
