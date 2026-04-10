package com.app.threetier.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

//ID, STUDENT_KOR, STUDENT_ENG, STUDENT_MATH,
//(STUDENT_KOR + STUDENT_ENG + STUDENT_MATH) AS TOTAL,
//ROUND((STUDENT_KOR + STUDENT_ENG + STUDENT_MATH)/3 ,2) AS AVERAGE
@Component
@Data
public class StudentDTO {
    private Long id;
    private String studentName;
    private Integer studentKor;
    private Integer studentEng;
    private Integer studentMath;
    private Integer total;
    private Double average;
}
