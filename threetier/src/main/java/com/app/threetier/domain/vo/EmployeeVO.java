package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmployeeVO {
    private Long id;
    private String employeeName;
    private String employeeCommute;
}
