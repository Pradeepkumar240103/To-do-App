package com.todoapp.backend.service;

import com.todoapp.backend.entity.Task;
import com.todoapp.backend.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task getById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task create(Task task) {
        return repo.save(task);
    }

    public Task update(String id, Task updated) {
        Task existing = getById(id);
        existing.setTitle(updated.getTitle());
        existing.setStatus(updated.getStatus());
        existing.setDate(updated.getDate());
        return repo.save(existing);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    // ✅ Clear all tasks and save new list
    public List<Task> replaceAll(List<Task> newTasks) {
        repo.deleteAll();      // clear existing tasks
        return repo.saveAll(newTasks); // save new tasks
    }
}

