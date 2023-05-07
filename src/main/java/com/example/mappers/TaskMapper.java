package com.example.mappers;
import com.example.dto.task.NewOrUpdateTaskDto;
import com.example.dto.task.TaskDto;
import com.example.models.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);
    Task toTask(TaskDto taskDto);
    Task toTask(NewOrUpdateTaskDto taskDto);
}
