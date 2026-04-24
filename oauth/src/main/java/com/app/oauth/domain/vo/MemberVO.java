package com.app.oauth.domain.vo;

import com.app.oauth.domain.dto.member.dto.MemberDTO;
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


    public static MemberVO from(MemberDTO memberDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(memberDTO.getId());
        memberVO.setMemberEmail(memberDTO.getMemberEmail());
        memberVO.setMemberPassword(memberDTO.getMemberPassword());
        memberVO.setMemberPicture(memberDTO.getMemberPicture() != null ? memberDTO.getMemberPicture() : "/default.jpg");
        memberVO.setMemberName(memberDTO.getMemberName());
        memberVO.setMemberNickname(memberDTO.getMemberNickname() != null ? memberDTO.getMemberNickname() : "개복치 1단계");
        return memberVO;
    }
}
