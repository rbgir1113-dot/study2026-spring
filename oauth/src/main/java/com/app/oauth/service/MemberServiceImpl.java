package com.app.oauth.service;

import com.app.oauth.domain.dto.JwtTokenDTO;
import com.app.oauth.domain.dto.MemberDTO;
import com.app.oauth.domain.vo.MemberVO;
import com.app.oauth.domain.vo.SocialMemberVO;
import com.app.oauth.exception.MemberException;
import com.app.oauth.repository.MemberDAO;
import com.app.oauth.repository.SocialMemberDAO;
import com.app.oauth.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final SocialMemberDAO socialMemberDAO;
    private final SocialMemberVO socialMemberVO;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public Map<String, Object> join(MemberDTO memberDTO) {
//        로그인페이지
        Map<String, Object> result = new HashMap<>();

//        자동로그인
        Map<String, Object> claims = new HashMap<>();

//        1. 중복 여부 검사
//        중복된 값이 있으면 throw
        if(memberDAO.existsByMemberEmail(memberDTO.getMemberEmail())){
            throw new RuntimeException("중복된 이메일입니다.");
        }
//        중복된 값이 없으면 서비스 처리

//        2. 비밀번호 암호화(단방향)
//        소셜 회원가입시 비밀번호가 없음
//        로컬 회원가입만 비밀번호를 가지고 있음

//        3. DB에 회원 추가
//        DTO -> MemberVO
//        DTO -> SocialMemberVO
//        insert 처리 (트랜잭션 관리) throw
        MemberVO memberVO = MemberVO.from(memberDTO);
        SocialMemberVO socialMemberVO = SocialMemberVO.from(memberDTO);

//        socialMemberVO.getSocialMemberProvider().equals("local")
//        윗 코드보다 아래 코드가 좋음 -> 문자열에 .equals는 null값이 안 들어가기 때문에
//        null값일 경우 false가 반환됨
        if("local".equals(socialMemberVO.getSocialMemberProvider())){
            memberVO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        }
        memberDAO.save(memberVO);
        socialMemberVO.setMemberId(memberVO.getId());


        socialMemberDAO.save(socialMemberVO);

//        4. Custom Exception 처리
//        5. 리턴 여부 확인
        result.put("result", true);
        result.put("message", "회원가입이 완료되었습니다.");

        claims.put("id", memberVO.getId());
        claims.put("memberEmail", memberVO.getMemberEmail());
        claims.put("memberProvider", socialMemberVO.getSocialMemberProvider());

        result.put("claim", claims);
//        회원 가입 후 로그인 페이지 -> 메세지 반환
        return result;

//        6. 회원가입 후 자동 로그인 -> 유저 정보 반환
    }


//    로컬 로그인
    @Override
    public JwtTokenDTO login(MemberDTO memberDTO) {
        // 사용자가 맞는지 검사 (이메일, 비밀번호, 프로바이더(local))

        if(!memberDAO.existsByMemberEmail(memberDTO.getMemberEmail())){

        }

        MemberVO memberVO = MemberVO.from(memberDTO);
        // 화면에서 받은 비밀번호를 단방향 얌호화
        // 회원 유무 검사
        MemberDTO foundMember = memberDAO
                .findByEmailAndPassword(memberDTO.getMemberEmail())
                .orElseThrow(() -> {
                    throw new MemberException("회원이 아닙니다", HttpStatus.BAD_REQUEST);
                });
        // 화면에서 받은 비밀번호, DB에 있는 비밀번호 검사
        if(!passwordEncoder.matches(memberDTO.getMemberPassword(), foundMember.getMemberPassword())) {
            throw new MemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }

        // 토큰 생성(access, refresh)
        Map<String, String> claims = new HashMap<>();
        claims.put("id", foundMember.getId().toString());
        claims.put("memberEmail", foundMember.getMemberEmail());
        claims.put("memberProvider", "local");

        String accessToken = jwtTokenUtil.generateAccessToken(claims);
        String refreshToken = jwtTokenUtil.generateRefreshToken(claims);

        JwtTokenDTO jwtTokenDTO = new JwtTokenDTO();
        jwtTokenDTO.setAccessToken(accessToken);
        jwtTokenDTO.setRefreshToken(refreshToken);

        return jwtTokenDTO;

    }


//    소셜 로그인
    @Override
    public void socialLogin(MemberDTO memberDTO) {

    }
}
