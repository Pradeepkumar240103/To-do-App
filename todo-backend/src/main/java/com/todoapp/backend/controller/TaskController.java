package com.todoapp.backend.controller;

import com.todoapp.backend.entity.Task;
import com.todoapp.backend.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "https://react-todo-spring.vercel.app/")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return service.getById(id);
    }

	/*
	 * @PostMapping public Task createTask(@RequestBody Task task) { return
	 * service.create(task); }
	 */

    @PostMapping
    public List<Task> replaceAllTasks(@RequestBody List<Task> tasks) {
        return service.replaceAll(tasks);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        service.delete(id);
    }
}

