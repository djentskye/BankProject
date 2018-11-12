package com.hibernate.security;

public class Main {

    public static void main(String args[]) {
        System.out.println("Hello!");
        System.out.println(JwtGenerateToken.verifyToken(JwtGenerateToken.newToken("Hello!")).getToken());
    }
}
