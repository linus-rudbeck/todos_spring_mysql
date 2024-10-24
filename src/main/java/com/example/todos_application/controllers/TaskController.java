package com.example.todos_application.controllers;

import com.example.todos_application.models.Task;
import com.example.todos_application.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public Iterable<Task> getTasks(){
        var tasks = service.readAll();
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String id){
        Task task = service.readOne(id);
        return task;
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody Task task){
        service.createTask(task);
        return new ResponseEntity<>("Task created", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable String id, @RequestBody Task task){
        service.updateTask(id, task);
        return new ResponseEntity<>("Task updated", HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id){
        service.deleteTask(id);
        return new ResponseEntity<>("Task deleted", HttpStatus.OK);
    }


}
