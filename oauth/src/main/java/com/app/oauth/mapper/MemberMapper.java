package com.app.oauth.mapper;

import com.app.oauth.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

//    회원추가
    public void insert(MemberVO memberVO);

//    회원 조회(ID)
    public MemberVO select(Long id);

//    회원 조회(memberEmail)
    public MemberVO selectByEmail(String memberEmail);

//    회원 가입 여부 조회(memerEmail)
    public boolean existsByEmail(String memberEmail);

//    회원 수정
    public void update(MemberVO memberVO);

//    회원 삭제
    public void delete(Long id);
}
