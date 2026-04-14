package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
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

    @Test
    public void insertMemberTest() {
        MemberJoinRequestDTO MemberJoinRequestDTO = new MemberJoinRequestDTO();
        MemberJoinRequestDTO.setMemberEmail("test147@gmail.com");
        MemberJoinRequestDTO.setMemberPassword("1234");
        MemberJoinRequestDTO.setMemberName("장길동");
        memberService.join(MemberJoinRequestDTO);
    }


    @Test
    public void memberUpdateTest() {
        MemberUpdateRequestDTO memberUpdateRequestDTO = new MemberUpdateRequestDTO();
        memberUpdateRequestDTO.setMemberPassword("1234");
        memberUpdateRequestDTO.setMemberName("홍홍홍");
        memberUpdateRequestDTO.setId(1L);
        memberService.updateMemberInfo(memberUpdateRequestDTO);
    }
}
