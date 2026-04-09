package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {
    private Long id;
    private Integer taskKor;
    private Integer taskEng;
    private Integer taskMath;
}
