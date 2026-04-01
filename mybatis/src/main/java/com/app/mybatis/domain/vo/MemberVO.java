package com.app.mybatis.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
