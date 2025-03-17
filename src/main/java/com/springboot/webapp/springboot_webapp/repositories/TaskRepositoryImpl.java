package com.springboot.webapp.springboot_webapp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.springboot.webapp.springboot_webapp.exceptions.TaskNotFoundException;
import com.springboot.webapp.springboot_webapp.models.project.Task;

@Repository
public class TaskRepositoryImpl  implements TaskRepository{

    private List<Task> data;
    private  final Faker faker = new Faker();

    public TaskRepositoryImpl() {
        data= new ArrayList<>();
        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle(faker.app().name());
        task1.setDescription(faker.lorem().sentence());
        task1.setCompleted(false);
        task1.setIsActive(true);
        
        Task task2= new Task();
        task2.setId(2L);
        task2.setTitle(faker.app().name());
        task2.setDescription(faker.lorem().sentence());
        task2.setCompleted(false);
        task2.setIsActive(true);
        data.add(task1);
        data.add(task2);

    }


    @Override
    public List<Task> findAll() {
       return this.data.stream().filter(Task::getIsActive).toList();
    }

    @Override
    public Task findById(Long id) {
        return this.data.stream().filter(task -> task.getId().equals(id) && task.getIsActive()).findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Error: Task not found"));
    }

    @Override
    public Task save(Task task) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Task update(Task task) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
