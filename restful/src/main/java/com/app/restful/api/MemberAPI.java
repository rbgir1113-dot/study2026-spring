package com.app.restful.api;

import com.app.restful.domain.dto.MemberJoinRequestDTO;
import com.app.restful.domain.dto.MemberResponseDTO;
import com.app.restful.domain.dto.MemberUpdateRequestDTO;
import com.app.restful.domain.vo.MemberVO;
import com.app.restful.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//  리턴값을 JSON으로 처리
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberAPI {
    private final MemberService memberService;

    //  회원 목록 조회 서비스
    @Operation(summary = "회원 목록 조회 서비스", description = "회원 목록을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
    @GetMapping("")
    public Iterable<MemberResponseDTO> getMemberInfoList() {
        return memberService.getMemberInfoList();
    }

    // 회원 정보 조회 서비스
    @Operation(summary = "회원 단일 조회 서비스", description = "회원을 조회해서 리스트로 반환하는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 목록 조회 성공")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    @GetMapping("/{id}")
    public MemberResponseDTO getMemberInfo(@PathVariable Long id) {

        return memberService.getMemberInfo(id);
    }

    // 회원 추가 서비스
    @Operation(summary = "회원 가입 서비스", description = "회원 정보를 받아서 회원가입을 시켜주는 서비스")
    @ApiResponse(responseCode = "201", description = "회원 가입 성공")
    @PostMapping("join")
    public void join(@RequestBody MemberJoinRequestDTO memberJoinRequestDTO) {
        memberService.join(memberJoinRequestDTO);
    }

//    로그인
    @Operation(summary = "회원 로그인 서비스", description = "회원 이메일과 비밀번호를 검증후 로그인 해주는 서비스")
    @ApiResponse(responseCode = "200", description = "로그인 완료")
    @PostMapping("login")
    public MemberResponseDTO login(@RequestBody MemberVO memberVO) {
        return memberService.login(memberVO);
    }


    @Operation(summary = "회원 정보 수정 서비스", description = "회원 정보의 비밀번호와 이름을 수정하게 해주는 서비스")
    @ApiResponse(responseCode = "200", description = "회원 정보 수정 완료")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    @PutMapping("/{id}")
    public void update(@RequestBody MemberUpdateRequestDTO memberUpdateRequestDTO, @PathVariable Long id) {
        memberUpdateRequestDTO.setId(id);
        memberService.updateMemberInfo(memberUpdateRequestDTO);
    }

//
    @Operation(summary = "회원 탈퇴 서비스", description = "회원 정보를 삭제하게 해주는 서비스")
    @ApiResponse(responseCode = "204", description = "회원 삭제 완료")
    @Parameter(
            name = "id",
            description = "회원 번호",
            required = true,
            in = ParameterIn.PATH,
            example = "1",
            schema = @Schema(type = "number") // 스키마 타입
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.withdrawByMemberPost(id);
        memberService.withdraw(id);
    }
}
