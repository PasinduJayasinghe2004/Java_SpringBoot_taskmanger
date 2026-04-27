package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTask() {
        return repository.findAll();
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }

    public Task getTaskById(String id) {
        return repository.findById(id).orElse(null);
    }

}
