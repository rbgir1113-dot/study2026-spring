package com.app.oauth.repository;

import com.app.oauth.domain.dto.member.dto.MemberDTO;
import com.app.oauth.domain.vo.MemberVO;
import com.app.oauth.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

//    회원 추가
    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }


//    회원 조회(id)
    public Optional<MemberDTO> findById(Long id) {
        return Optional.ofNullable(memberMapper.select(id));
    }

//    회원 조회(memberEmail)
    public Optional<MemberVO> findByEmail(String memberEmail) {
        return Optional.ofNullable(memberMapper.selectByEmail(memberEmail));
    }

//    회원 조회(memberEmail and memberPassword)
    public Optional<MemberDTO> findByEmailAndPassword(String memberEmail) {
        return Optional.ofNullable(memberMapper.selectByMemberEmailAndMemberPassword(memberEmail));
    }

//    회원 가입 여부 조회(memberEmail)
    public boolean existsByMemberEmail(String memberEmail) {
        return memberMapper.existsByMemberEmail(memberEmail);
    }

//    회원 수정
    public void update(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }

//    회원 삭제
    public void delete(Long id) {
        memberMapper.delete(id);
    }
}
