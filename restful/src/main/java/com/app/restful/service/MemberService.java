package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;

import java.util.List;
import java.util.Optional;

public interface MemberService {
//    회원 가입
    public void join(MemberJoinRequestDTO memberJoinRequestDTO);

//    로그인 (Optional은 나중에 바뀔 예정)
    public MemberResponseDTO login(MemberVO memberVO);

//    회원 정보 조회
    public MemberResponseDTO getMemberInfo(Long id);

//    회원 전체 조회
    public List<MemberResponseDTO> getMemberInfoList();

//    이메일 유무 조회
    public void checkMemberEmailDuplicate(String memberEmail);


//    회원정보 변경
    public void updateMemberInfo(MemberUpdateRequestDTO memberUpdateRequestDTO);
//    회원 비밀번호 변경(마이페이지)
//    회원 비밀번호 변경(로그인 하기 전)
//    회원 탈퇴
    public void withdraw(Long id);
}
