package com.app.oauth.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AwsUtilTests {

    @Autowired
    private AwsS3Util awsS3Util;

    @Test
    public void getPathTest() {
        log.info("awsS3Util : {}", awsS3Util.getPath());
    }

}
