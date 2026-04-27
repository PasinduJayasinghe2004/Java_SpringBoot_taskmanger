package com.example.taskmanger;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;


@Entity

public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;
    private String title;

    public Task(String title){

        this.title=title;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
}
