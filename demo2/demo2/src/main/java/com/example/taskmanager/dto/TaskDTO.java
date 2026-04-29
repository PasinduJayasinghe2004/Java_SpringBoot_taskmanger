package com.example.taskmanager.dto;

public class TaskDTO {
    private String id;
    private String title;

    public TaskDTO(String id,String title){
        this.id=id;
        this.title=title;
    }
    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
}
