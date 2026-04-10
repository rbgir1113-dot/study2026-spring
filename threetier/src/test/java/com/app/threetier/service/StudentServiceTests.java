package com.app.threetier.service;

import com.app.threetier.domain.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class StudentServiceTests {

    @Autowired
    private StudentService studentService;

    @Test
    public void registerStudentTest() {
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName("장보고");
        studentVO.setStudentKor(20);
        studentVO.setStudentEng(70);
        studentVO.setStudentMath(90);
        studentService.registerStudent(studentVO);

        log.info("student : {}", studentService.getStudent(studentVO.getId()));
    }

    @Test
    public void getStudentListTest() {
        studentService.getStudentList().forEach(student -> log.info("student : {}", student));
    }

    @Test
    public void getStudentTest() {
        log.info("student : {}", studentService.getStudent(1L));
    }

    @Test
    public void updateStudentTest() {
        StudentVO studentVO = new StudentVO();
        log.info("student : {}", studentService.getStudent(1L));

        studentVO.setId(1L);
        studentVO.setStudentName("홍길동");
        studentVO.setStudentKor(100);
        studentVO.setStudentEng(100);
        studentVO.setStudentMath(100);
        studentService.updateStudent(studentVO);
        log.info("student : {}", studentService.getStudent(1L));
    }

    @Test
    public void deleteStudentTest() {
        studentService.deleteStudent(1L);
    }
}
