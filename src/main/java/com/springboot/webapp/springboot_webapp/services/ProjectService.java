package com.springboot.webapp.springboot_webapp.services;

import java.util.List;
import java.util.Optional;

import com.springboot.webapp.springboot_webapp.models.dto.ProjectDto;
import com.springboot.webapp.springboot_webapp.models.project.Project;

public interface ProjectService {
    List<Project> findAll();

    Optional<Project> findById(Long id);
    Project createProject(Project project);

    Project updateProject(Long id, ProjectDto project);
    void deleteProject(Long id);
}
