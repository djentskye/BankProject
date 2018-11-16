package com.hibernate.security;

import com.hibernate.entity.User;
import com.hibernate.security.auth.JwtDecodeToken;
import com.hibernate.service.UserService;

public class Main {

    public static void main(String args[]) {
        System.out.println("Hello!");
        System.out.println(JwtGenerateToken.verifyToken(JwtGenerateToken.newToken("Hello!")).getToken());
        System.out.println(JwtDecodeToken.decodeUserJwt("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJiYW5rcHJvamVjdCJ9.8GIzCGQ3TQZPAb2lc1VO7q8vyb2zEMsSmidm4tiMHmE"));

    }
}
