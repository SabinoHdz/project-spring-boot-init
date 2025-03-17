package com.springboot.webapp.springboot_webapp.controllers.projects;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webapp.springboot_webapp.exceptions.ProjectNotFoundException;
import com.springboot.webapp.springboot_webapp.models.dto.ProjectDto;
import com.springboot.webapp.springboot_webapp.models.project.Project;
import com.springboot.webapp.springboot_webapp.services.ProjectServiceImpl;

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

        Project project = projectService.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("El proyecto no existe!!"));
        return project;
    }

    // @RequestMapping("/only/{id}")
    // public Project getProjectByIdValue(@PathVariable Long id) {
    // return projectService.findById(id);
    // }

    @PostMapping("/createProject")
    public Project createProject(@RequestParam String name, @RequestParam String description) {

        System.err.println(name);
        System.err.println(description);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(System.currentTimeMillis());
        String dateFormat = formatter.format(date);
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        project.setStartDate(dateFormat);
        project.setIsActive(true);
        Project projectResponse = projectService.createProject(project);

        return projectResponse;
    }
    @PostMapping("/updateProject")
    public Project updateProject(@RequestParam Long id, @RequestBody ProjectDto projectDto) {

        Project projectUpdate = projectService.updateProject(id, projectDto);
        return projectUpdate;
    }

    @PostMapping("/deleteProject")
    public String deleteProject(@RequestParam Long id) {
        projectService.deleteProject(id);
        return "Project deleted successfully";
    }
}
