package com.hibernate.security;

import com.hibernate.security.auth.JwtDecodeToken;

public class Main {

    //ONLY FOR TESTING
    public static void main(String args[]) {
        System.out.println("Hello!");
        System.out.println(JwtDecodeToken.decodeUserJwt("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJiYW5rcHJvamVjdCIsInVzZXJuYW1lIjoiRGF2aWRSeWFuIiwicGFzc251bSI6MTIzNDU2Nzg5fQ.oAmDBb69uc5Ck82RhKrdtlFGRkjJq0etYXdTZ9h27yg"));
    }
}
