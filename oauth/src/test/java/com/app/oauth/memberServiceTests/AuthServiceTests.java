package com.app.oauth.memberServiceTests;

import com.app.oauth.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AuthServiceTests {

    @Autowired
    private AuthService authService;

    @Test
    public void sendMemberPhoneCodeTest() {
        authService.sendMemberPhoneVerificationCode("01035059904");
    }

    @Test
    public void verifyMemberPhoneCodeTest() {
        log.info("{}",authService.verifyMemberPhoneVerificationCode("01035059904", "123456"));
    }
}
