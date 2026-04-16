package com.app.restful.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Schema(description = "회원 정보 수정 DTO")
public class MemberUpdateRequestDTO {
    @Schema(description = "회원 번호", required = true, example = "1")
    private Long id;
    @Schema(description = "회원 이름", required = true, example = "홍길동")
    private String memberName;
    @Schema(description = "회원 비밀번호", required = true, example = "1234")
    private String memberPassword;
}
