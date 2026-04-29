package com.example.taskmanager.model;

import jakarta.persistence.Id;

import java.lang.annotation.Documented;


@Document(collection="users");
public class User {
    @Id
    private String id;
    private String username;
    private String password;

    public User(){}
    public User(String username,String password){
        this.username=username;
        this.password=password;


    }
    public String getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return  password;
    }
}
