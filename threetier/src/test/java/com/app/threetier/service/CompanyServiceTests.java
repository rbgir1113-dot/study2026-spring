package com.app.threetier.service;

import com.app.threetier.domain.vo.CompanyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CompanyServiceTests {

    @Autowired
    private CompanyService companyService;

    @Test
    public void registerCommuteStatusTest(){
        CompanyVO companyVO = new CompanyVO();
        companyVO.setCompanyName("코리아IT");
        companyVO.setLeaveToWorkDateTime("2026-04-10 18:00:00");

        companyService.registerCommuteStatus(companyVO);
    }
}
