package com.utkarsh.taskspring;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
     final List<Task> taskList =  List.of(
            new Task(1, "drink water"),
            new Task(2, "complete training"),
            new Task(3, "go for shopping")
    );

//    public Task findTaskById(int id) {
//        return taskList.stream()
//                .filter(task -> task.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }

}
