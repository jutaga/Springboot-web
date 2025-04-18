package com.juanpablo.curso.springboot.webapp.springboot_web.models;

import java.util.UUID;

public class User {

    private UUID _id = UUID.randomUUID();
    private String name;
    private String lastName;
    private String email;
    private String password;


    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;        
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UUID getId() {
        return _id;
    }
    
}


