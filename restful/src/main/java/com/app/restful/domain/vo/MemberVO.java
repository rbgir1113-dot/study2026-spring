package com.app.restful.domain.vo;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MemberVO implements Serializable {  // Serializable -> 다른 서버와 이어주게 도와주는 방법 ( 직렬화 )
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;


    public static MemberVO from(MemberJoinRequestDTO memberJoinRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail(memberJoinRequestDTO.getMemberEmail());
        memberVO.setMemberPassword(memberJoinRequestDTO.getMemberPassword());
        memberVO.setMemberName(memberJoinRequestDTO.getMemberName());
        return memberVO;
    }

    public static MemberVO from(MemberUpdateRequestDTO memberUpdateRequestDTO) {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(memberUpdateRequestDTO.getId());
        memberVO.setMemberName(memberUpdateRequestDTO.getMemberName());
        memberVO.setMemberPassword(memberUpdateRequestDTO.getMemberPassword());
        return memberVO;
    }
}
