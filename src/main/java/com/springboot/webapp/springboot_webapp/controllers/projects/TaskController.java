package com.springboot.webapp.springboot_webapp.controllers.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springboot_webapp.models.project.Task;
import com.springboot.webapp.springboot_webapp.services.TaskServiceImpl;
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskService;
    @GetMapping(value = "/query")
    public List<Task> getTasks(){
        return  taskService.findAll();
    }
    @GetMapping(value = "/getTaskById")
    public Task getTaskById(@RequestParam Long id){
       
        return taskService.findById(id);

    }
    @PostMapping("/createTask")
    public Task  createTask(){
       return taskService.save(new Task());
    }
    @PostMapping("/updateTask")
    public String updateTask(@RequestParam Long id){
        return "Task with id: " + id + " updated";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam Long id){
        return "Task with id: " + id + " deleted";
    }
    
}
