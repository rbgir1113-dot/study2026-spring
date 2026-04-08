package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MemberVO implements Serializable {  // Serializable -> 다른 서버와 이어주게 도와주는 방법 ( 직렬화 )
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
