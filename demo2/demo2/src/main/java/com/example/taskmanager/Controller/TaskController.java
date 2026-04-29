package com.example.taskmanager.Controller;

import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    public TaskController(TaskService taskService) {
        this.service = service;
    }

    @PostMapping
    public TaskDTO addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping
    public List<TaskDTO> getTasks() {
        return service.getAllTask();
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return "Task deleted successfully";
    }

}