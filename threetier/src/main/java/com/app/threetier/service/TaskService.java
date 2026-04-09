package com.app.threetier.service;

import com.app.threetier.domain.vo.TaskVO;
import org.springframework.stereotype.Service;


public interface TaskService {

    public void saveTask(TaskVO taskVO);

}
