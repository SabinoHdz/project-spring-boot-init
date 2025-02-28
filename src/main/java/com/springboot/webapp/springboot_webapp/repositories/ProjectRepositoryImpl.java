package com.springboot.webapp.springboot_webapp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.springboot.webapp.springboot_webapp.models.dto.ProjectDto;
import com.springboot.webapp.springboot_webapp.models.project.Project;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

        private  final Faker faker = new Faker();
        private List<Project> projects;

        public ProjectRepositoryImpl() {
         projects= new ArrayList<>();

         Project project1 = new Project();
            project1.setId(1L);
            project1.setName(faker.app().name());
            project1.setDescription(faker.lorem().sentence());
            project1.setStartDate(faker.date().birthday().toString());
            project1.setCompleted(false);
            project1.setIsActive(true);
            projects.add(project1);

        Project project2 = new Project();
            project2.setId(2L);
            project2.setName(faker.app().name());
            project2.setDescription(faker.lorem().sentence());
            project2.setStartDate(faker.date().birthday().toString());
            project2.setCompleted(false);
            project2.setIsActive(true);
            projects.add(project2);

        }
    @Override
    public List<Project> getFindAll() {
    
        return projects.stream().filter(Project::getIsActive).toList();
    }

    @Override
    public Project getProjectById(Long id) {

        return projects.stream().filter(project -> project.getId().equals(id) && project.getIsActive()).findFirst()
                .orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        project.setId((long) (projects.size() + 1));
        projects.add(project);
        return project;
    }

    @Override
    public Project updaProject(Long id, ProjectDto project) {
        Project projectSearch = projects.stream().filter(project1 -> project1.getId().equals(id)).findFirst()
                .orElse(null);
        if (projectSearch != null) {
            projectSearch.setName(project.getName() != null ? project.getName() : projectSearch.getName());
            projectSearch.setDescription(
                    project.getDescription() != null ? project.getDescription() : projectSearch.getDescription());
            projectSearch.setStartDate(
                    project.getStartDate() != null ? project.getStartDate() : projectSearch.getStartDate());
            projectSearch.setCompleted(
                    project.getCompleted() != null ? project.getCompleted() : projectSearch.getCompleted());
            projectSearch
                    .setIsActive(project.getIsActive() != null ? project.getIsActive() : projectSearch.getIsActive());

        }
        return projectSearch;
    }

    @Override
    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        if (project != null) {
            project.setIsActive(false);

        }

    }
    
}
