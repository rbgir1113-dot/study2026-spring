package com.app.oauth.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SmsUtilTests {

    @Autowired
    private SmsUtil smsUtil;

    @Test
    public void smsTest(){
        smsUtil.sendOneMemberPhone("01035059904", "");
    }

    @Test
    public void emailTest() {
        smsUtil.sendOneMemberEmail("kangdh010511@gmail.com", "[Success Log]","감대훈 차렷");
    }
}
