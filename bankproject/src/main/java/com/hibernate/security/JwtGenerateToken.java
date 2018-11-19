package com.hibernate.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hibernate.entity.User;

public class JwtGenerateToken {

    public static String newToken(String toEncrypt) {
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("abcd");
            token = JWT.create()
                    .withIssuer("bankproject")
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            System.out.println(exception);
            token = null;
        }
        return token;
    }

    public static String newUserToken(User toEncrypt) {
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("abcd");
            token = JWT.create()
                    .withIssuer("bankproject")
                    .withClaim("username", toEncrypt.getFirstName() + toEncrypt.getLastName())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            System.out.println(exception);
            token = null;
        }
        return token;
    }

    public static DecodedJWT verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("abcd");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("bankproject")
                    .build();
            jwt = verifier.verify(token);
        } catch (JWTVerificationException exception) {
            System.out.println(exception);
        }
        return jwt;
    }
}
