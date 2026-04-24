package com.app.oauth.service;

import com.app.oauth.domain.dto.member.dto.response.ApiResponseDTO;
import com.app.oauth.domain.dto.member.dto.JwtTokenDTO;
import com.app.oauth.domain.dto.member.dto.MemberDTO;

public interface MemberService {
    // 회원가입
    public ApiResponseDTO join(MemberDTO memberDTO);



    // 회원 수정

    // 토큰 -> 회원 정보 조회
    public ApiResponseDTO me(String token);
    // 회원 탈퇴
}
