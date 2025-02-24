package com.springboot.webapp.springboot_webapp.models.project;

public class Project {

    private Long id;
    private String name;
    private String description;
    private String startDate;
    private Boolean completed;
    public Boolean isActive;
    public Project() {
    }
    public Project(Long id,String name, String description, String startDate, Boolean completed, Boolean isActive) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.completed = completed;
        this.isActive = isActive;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    

}
