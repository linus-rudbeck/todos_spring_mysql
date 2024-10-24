package com.example.todos_application.services;

import com.example.todos_application.models.Task;
import com.example.todos_application.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void createTask(Task task){
        repository.save(task);
    }

    public Iterable<Task> readAll(){
        var tasks = repository.findAll();
        return tasks;
    }

    public Task readOne(String id){
        return repository.findById(id).get();
    }

    public void updateTask(String id, Task updatedTask){

        Optional<Task> existingTask = repository.findById(id);

        if(existingTask.isPresent()){
            Task task = existingTask.get();

            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());

            repository.save(task);
        }
    }

    public void deleteTask(String id){
        repository.deleteById(id);
    }

}
