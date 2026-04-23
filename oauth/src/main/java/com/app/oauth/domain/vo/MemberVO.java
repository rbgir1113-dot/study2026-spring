package com.app.oauth.domain.vo;

import com.app.oauth.domain.dto.MemberJoinDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

//ID NUMBER CONSTRAINT PK_OAUTH_MEMBER PRIMARY KEY ,
//MEMBER_EMAIL VARCHAR2(255) UNIQUE NOT NULL,
//MEMBER_PASSWORD VARCHAR2(255),
//MEMBER_PICTURE VARCHAR2(255) DEFAULT '/default.jpg',
//MEMBER_NAME VARCHAR2(255),
//MEMBER_NICKNAME VARCHAR2(255) DEFAULT '개복치 1단계',
//MEMBER_PROVIDER VARCHAR2(255) DEFAULT 'local'

@Component
@Data
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberPicture;
    private String memberName;
    private String memberNickname;

    {
//        초기화 블록
        this.setMemberPicture("/default.jpg");
        this.setMemberNickname("개복치 1단계");
    }

    public static MemberVO from(MemberJoinDTO memberJoinDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(memberJoinDTO.getId());
        memberVO.setMemberEmail(memberJoinDTO.getMemberEmail());
        memberVO.setMemberPassword(memberJoinDTO.getMemberPassword());
        memberVO.setMemberName(memberJoinDTO.getMemberName());
        memberVO.setMemberNickname(memberJoinDTO.getMemberNickname());
        memberVO.setMemberPicture(memberJoinDTO.getMemberPicture());
        return memberVO;
    }
}
