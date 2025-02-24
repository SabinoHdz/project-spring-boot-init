package com.springboot.webapp.springboot_webapp.repositories;

import java.util.List;

import com.springboot.webapp.springboot_webapp.models.project.Project;

public interface ProjectRepository {
   List<Project> getFindAll();
   Project getProjectById(Long id);
   Project createProject(Project project);
   Project updaProject(Long id, Project project);
    void deleteProject(Long id);
}
