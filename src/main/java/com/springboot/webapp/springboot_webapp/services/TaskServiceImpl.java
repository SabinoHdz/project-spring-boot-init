package com.springboot.webapp.springboot_webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webapp.springboot_webapp.models.project.Task;
import com.springboot.webapp.springboot_webapp.repositories.TaskRepositoryImpl;

@Service
public class TaskServiceImpl  implements TaskService{
    @Autowired
    private  TaskRepositoryImpl taskRepository;


    @Override
    public List<Task> findAll() {
       return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
    
}
