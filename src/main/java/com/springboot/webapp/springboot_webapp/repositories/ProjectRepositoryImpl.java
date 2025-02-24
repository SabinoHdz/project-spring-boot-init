package com.springboot.webapp.springboot_webapp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
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
    
       return projects;
    }

    @Override
    public Project getProjectById(Long id) {

        return projects.stream().filter(project-> project.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProject'");
    }

    @Override
    public Project updaProject(Long id, Project project) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updaProject'");
    }

    @Override
    public void deleteProject(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProject'");
    }
    
}
