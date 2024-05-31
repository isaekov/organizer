package com.example.organizer.service;

import com.example.organizer.entity.Task;
import com.example.organizer.rpository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {



    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task findByUserId(int userId) {
        Optional<Task> optionalTask = taskRepository.findById(userId);

        if (optionalTask.isEmpty()) {
            throw new RuntimeException("Не найдена задача");
        }
        return optionalTask.get();
    }
}
