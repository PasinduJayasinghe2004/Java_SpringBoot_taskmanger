package com.example.taskmanger;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/tasks")

public class TaskController {
    
    
    @Autowired
    private TaskService TaskService;


    @PostMapping;
    public String addTask(@RequestBody Task task){
        tasks.add(task);
        return "Task Added successfully";
    }
    @GetMapping
    public List<Task> getTasks(){
        return TaskService.getAllTask();
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){
        TaskService.deleteTask(id);
        return "Delete successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){
        tasks.removeIf(task -> task.getId() == id);
        return "Task deleted";
    }





}
