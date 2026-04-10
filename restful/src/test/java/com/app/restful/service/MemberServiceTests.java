package com.app.restful.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void getMember() {
        log.info("memberService : {}", memberService.getMemberInfo(1L));
    }

    @Test
    public void getAllMember() {
        log.info("memberService : {}", memberService.getMemberInfoList());
    }
}
