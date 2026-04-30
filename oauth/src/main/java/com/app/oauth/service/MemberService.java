package com.app.oauth.service;

import com.app.oauth.domain.dto.response.ApiResponseDTO;
import com.app.oauth.domain.dto.MemberDTO;
import com.app.oauth.domain.vo.MemberVO;

public interface MemberService {
    // 회원가입
    public ApiResponseDTO join(MemberDTO memberDTO);



    // 회원 수정

    // 썸네일 변경
    public ApiResponseDTO updatePicture(MemberVO memberVO);

    public void getDisplayPath(String fileName);

    // 토큰 -> 회원 정보 조회
    public ApiResponseDTO me(Long id);
    // 회원 탈퇴
}
