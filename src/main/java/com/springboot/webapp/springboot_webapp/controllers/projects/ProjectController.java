package com.springboot.webapp.springboot_webapp.controllers.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springboot_webapp.models.project.Project;
import com.springboot.webapp.springboot_webapp.services.ProjectServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectService = new ProjectServiceImpl();
    @RequestMapping("")
    public List<Project> getProjects() {
        return projectService.findAll();
    }
    @RequestMapping("/getProjectById")
    public Project getProjectById(@RequestParam Long id) {
        return projectService.findById(id);
    }

    @RequestMapping("/{id}")
    public Project getProjectByIdValue(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping("/createProject")
    public String createProject(){
        return "Project created";
    }
    @PostMapping("/updateProject")
    public String updateProject(Long id){
        return "Project with id: " + id + " updated";
    }
    
    @PostMapping("/deleteProject")

    public String deleteProject(Long id){
        return "Project with id: " + id + " deleted";
    }
}
