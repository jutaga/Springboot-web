package com.juanpablo.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanpablo.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {

        User user = new User("Juan", "Tabares", "juan@tabares.com", "123");

        Map<String, Object> bodyResponse = new HashMap<>();

        bodyResponse.put("title", "Hola mundo Spring Boot");
        bodyResponse.put("infoUser", user);

        return bodyResponse;
    }

}
