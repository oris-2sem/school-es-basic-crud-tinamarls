package com.example.services.impl;

import com.example.dto.task.NewOrUpdateTaskDto;
import com.example.dto.task.TaskDto;
import com.example.exceptions.NotFoundException;
import com.example.mappers.TaskMapper;
import com.example.models.Lesson;
import com.example.models.Parent;
import com.example.models.Student;
import com.example.models.Task;
import com.example.repositories.TaskRepository;
import com.example.services.LessonService;
import com.example.services.StudentService;
import com.example.services.StudyClassService;
import com.example.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    private final LessonService lessonService;

    private final StudentService studentService;

    @Override
    public TaskDto getTaskById(Long id) {
        return taskMapper.toDto(getTaskOrThrow(id));
    }

    @Override
    public TaskDto addTask(NewOrUpdateTaskDto newTask) {
        Task task = taskMapper.toTask(newTask);

        if(newTask.getLessonId() != null){
            task.setLesson(lessonService.findById(newTask.getLessonId()));
        }
        if(newTask.getStudentId() != null){
            task.setStudent(studentService.findById(newTask.getStudentId()));
        }

        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public TaskDto update(Long id, NewOrUpdateTaskDto updatedTask) {

        Task task = taskMapper.toTask(updatedTask);

        Lesson lesson = null;
        Student student = null;

        if(updatedTask.getLessonId() != null){
            lesson = lessonService.findById(updatedTask.getLessonId());
        }
        if(updatedTask.getStudentId() != null){
            student = studentService.findById(updatedTask.getStudentId());
        }

        task.setMark(updatedTask.getMark());
        task.setType(updatedTask.getType());
        task.setDescription(updatedTask.getDescription());
        task.setCommentary(updatedTask.getCommentary());
        task.setLesson(lesson);
        task.setStudent(student);

        return taskMapper.toDto(taskRepository.save(task));

    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.delete(getTaskOrThrow(id));
    }

    private Task getTaskOrThrow(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Задание с идентификатором <" + id + "> не найден"));
    }
}
