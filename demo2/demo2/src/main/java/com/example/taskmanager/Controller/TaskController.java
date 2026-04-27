package com.example.taskmanager.Controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

}