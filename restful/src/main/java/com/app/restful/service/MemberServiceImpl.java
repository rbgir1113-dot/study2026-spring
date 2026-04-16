package com.app.restful.service;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.exception.MemberException;
import com.app.restful.repository.MemberDAO;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PostDAO postDAO;

    @Override
    public void join(MemberJoinRequestDTO memberJoinRequestDTO) {
//        이메일 중복 여부 확인
//        회원 정보 추가 할 수 있도록 코드 리팩토링
        this.checkMemberEmailDuplicate(memberJoinRequestDTO.getMemberEmail());
//        서비스 단에서 DTO -> VO 로 옮겨담는다
        memberDAO.save(MemberVO.from(memberJoinRequestDTO));
    }

    //    이메일 중복 여부 확인
    @Override
    public void checkMemberEmailDuplicate(String memberEmail) {
        if(memberDAO.existMemberEmail(memberEmail) > 0){
            throw new MemberException("이메일이 존재합니다.", HttpStatus.CONFLICT);
        }
    }

    // 로그인 서비스
    // 아이디 또는 비밀번호가 일치하지 않으면 throw
    // 화면에 비밀번호 X -> ResponseDTO
    // 아이디와 비밀번호가 일치하는 회원정보를 화면으로 할당
    // 정석은
    @Override
    public MemberResponseDTO login(MemberVO memberVO) {
        return memberDAO
                .findByEmailAndPassword(memberVO)
                .map(MemberResponseDTO::from)
                .orElseThrow(()->{throw new MemberException("아이디 또는 비밀번호를 확인하세요.", HttpStatus.UNAUTHORIZED);});
    }

    //    회원 정보 조회(ID)
    @Override
    public MemberResponseDTO getMemberInfo(Long id) {
//        회원 비밀번호를 제거 후 화면에 출력
//        MemberVO foundMember = memberDAO.findById(id);
//        MemberResponseDTO memberResponseDTO = MemberResponseDTO.from(foundMember);
        return memberDAO
                .findById(id)
                .map(MemberResponseDTO::from)
                .orElseThrow(()->{throw new MemberException("회원을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST);});
    }

    //    회원 전체 조회
    @Override
    public List<MemberResponseDTO> getMemberInfoList() {
        return memberDAO.findAll().stream().map(MemberResponseDTO::from).toList();
    }

    //    회원 정보 수정
    @Override
    public void updateMemberInfo(MemberUpdateRequestDTO memberUpdateRequestDTO){
        memberDAO.update(MemberVO.from(memberUpdateRequestDTO));
    }

    //    회원 정보 삭제
    @Override
    public void withdraw(Long id){
        postDAO.deleteByMemberId(id);
        memberDAO.delete(id);
    }

    @Override
    public void withdrawByMemberPost(Long id) {
        postDAO.deleteByMemberId(id);
    }
}
