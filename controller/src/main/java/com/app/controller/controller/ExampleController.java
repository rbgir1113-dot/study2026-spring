package com.app.controller.controller;

import com.app.controller.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/ex/*")
public class ExampleController {

    @GetMapping("/ex01")
    public String ex01(String name, int age) {
        log.info("ex01 응답 완료");
        log.info("name : {}, age : {}, realAge : {}", name, age, age-1);

//        Get방식으로 데이터를 어떻게 보내야 하는가?
//        이름과 나이를 요청보내고,
//        이름과 나이 만나이를 로그에 출력하기

        return "ex01";
    }

    @PostMapping("/ex01")
    public void ex01Post(String name, int age) {
        log.info("name : {}, age : {}, realAge : {}", name, age, age - 1);
        // ex01.html
        // ex01 -> templates/ex01.html
        // ex/ex/ex01 -> templates/ex/ex/ex01.html
        // 응답되는 페이지의 파일 경로
    }

    @GetMapping("/ex02")
    public String ex02(String name, Model model) {
        model.addAttribute("name", name);
        return "ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("홍길동", "장보고", "이순신"));
        model.addAttribute("names", names);
        return "ex03";
    }

    @GetMapping("ex04")
    public String ex04(@ModelAttribute("name") String name) {
        return "ex04";
    }

    @GetMapping("ex05")
    public String ex05(@ModelAttribute("name") String name, @ModelAttribute("hobby") String hobby) {
        return "ex05";
    }
}