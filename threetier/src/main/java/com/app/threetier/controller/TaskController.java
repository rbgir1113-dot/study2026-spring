package com.app.threetier.controller;

import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/tasks/*")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("register")
    public void goToTask(Model model){
        model.addAttribute("taskVO", new TaskVO());
    }

    @PostMapping("register")
    public String taskScore(TaskVO taskVO, Model model){
        taskService.saveTask(taskVO);
        model.addAttribute("task", taskVO);
        return "tasks/result";  // redirect 없이 바로 뷰 반환
    }

    @GetMapping("result")
    public void goToResult(){;}

}
