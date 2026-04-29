package com.app.oauth.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class AuthCodeGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static String generateAuthCode(){
        // 100000 ~ 999999
        int code = random.nextInt(999999) + 100000;
        return String.valueOf(code);
    }


}
