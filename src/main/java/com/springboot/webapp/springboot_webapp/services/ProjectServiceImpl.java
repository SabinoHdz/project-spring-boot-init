package com.springboot.webapp.springboot_webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webapp.springboot_webapp.models.dto.ProjectDto;
import com.springboot.webapp.springboot_webapp.models.project.Project;
import com.springboot.webapp.springboot_webapp.repositories.ProjectRepositoryImpl;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepositoryImpl projectRepository;

    @Override
    public List<Project> findAll() {
       return projectRepository.getFindAll();
    }

    @Override
    public Project findById(Long id) {
      return projectRepository.getProjectById(id);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.createProject(project);
    }

    @Override
    public Project updateProject(Long id, ProjectDto projectDto) {

        return projectRepository.updaProject(id, projectDto);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteProject(id);
    }
    
}
