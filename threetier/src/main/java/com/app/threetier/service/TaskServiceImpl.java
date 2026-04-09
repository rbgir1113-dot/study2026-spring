package com.app.threetier.service;

import com.app.threetier.domain.vo.TaskVO;
import com.app.threetier.repository.TaskDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    @Override
    public void saveTask(TaskVO taskVO) {
        taskDAO.save(taskVO);
    }
}
