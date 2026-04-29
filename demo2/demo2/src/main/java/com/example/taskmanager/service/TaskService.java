package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;




    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskDTO addTask(Task task) {
        Task saved=repository.save(task);
        return new TaskDTO(saved.getId(),saved.getTitle());
    }

    public List<TaskDTO> getAllTask() {
        return repository.findAll()
                .stream()
                .map(task -> new TaskDTO(task.getId(), task.getTitle()))
                .collect(Collectors.toList());


    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public TaskDTO getTaskById(Long id) {
        Task task=repository.findById(id)
                .orElseThrow(()->new TaskNotFoundException("Task not found with id: "+ id));

        return new TaskDTO(task.getId(),task.getTitle());
    }

}
