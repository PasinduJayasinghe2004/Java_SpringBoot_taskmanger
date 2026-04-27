package com.example.taskmanger;

import org.springframework.beans.factory.annotation.Autowire;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;
    
    public Task addTask(Task task){
        return repository.save(task);
    }
    public List<Task> getAllTask(){
        return repository.findAll();
    }
    public void deleteTask(int id){
        repository.deleteById(id);
    }
    public Task getTaskById(int id){
     return repository.findById(id).orElse(null);
    }

}
