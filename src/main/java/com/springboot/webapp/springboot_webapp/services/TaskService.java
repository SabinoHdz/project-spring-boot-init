package com.springboot.webapp.springboot_webapp.services;

import java.util.List;

import com.springboot.webapp.springboot_webapp.models.project.Task;

public interface TaskService {

    List<Task> findAll();
    Task findById(Long id);
    Task save(Task task);
    Task update(Task task);
    void deleteById(Long id);
}
