package com.example.todos_application.repositories;

import com.example.todos_application.models.Task;
import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Task, String> {
}
