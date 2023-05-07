package com.example.services;

import com.example.dto.task.NewOrUpdateTaskDto;
import com.example.dto.task.TaskDto;

public interface TaskService {
    TaskDto getTaskById(Long id);

    TaskDto addTask(NewOrUpdateTaskDto newTask);

    TaskDto update(Long id, NewOrUpdateTaskDto updatedTask);

    void deleteTask(Long id);
}
