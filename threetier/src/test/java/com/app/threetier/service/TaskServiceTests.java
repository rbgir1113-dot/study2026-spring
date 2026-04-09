package com.app.threetier.service;

import com.app.threetier.domain.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @Test
    public void saveTask() {
        TaskVO taskVO = new TaskVO();
        taskVO.setTaskKor(20);
        taskVO.setTaskEng(20);
        taskVO.setTaskMath(20);
        taskService.saveTask(taskVO);
    }
}
