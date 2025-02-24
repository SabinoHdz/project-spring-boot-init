package com.springboot.webapp.springboot_webapp.services;

import java.util.List;

import com.springboot.webapp.springboot_webapp.models.project.Project;

public interface ProjectService {
    List<Project> findAll();
    Project findById(Long id);
    Project createProject(Project project);
    Project updateProject(Long id, Project project);
    void deleteProject(Long id);
}
