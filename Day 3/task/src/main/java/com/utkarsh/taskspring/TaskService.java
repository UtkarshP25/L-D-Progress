package com.utkarsh.taskspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task getTaskById(int id) {
        return taskRepository.taskList.stream()
                    .filter(task -> task.getId() == id)
                    .findFirst()
                    .orElse(null);
    }
}
