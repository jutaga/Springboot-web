package com.juanpablo.curso.springboot.webapp.springboot_web.controllers;

/* import java.util.ArrayList; */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanpablo.curso.springboot.webapp.springboot_web.models.User;
import com.juanpablo.curso.springboot.webapp.springboot_web.models.dto.UserDto;
/* import org.springframework.web.bind.annotation.RequestParam; */


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

    @GetMapping("/details-v2")
    public UserDto detailsV2() {

        User user = new User("Pablo", "Gallego", "pablo@gallego.com", "123");
        UserDto userDto = new UserDto("Hola mundo Spring Boot", user);

        return userDto;
    }

    @GetMapping("/list")      
    public List<User> List(){
        User user = new User("Juan", "Tabares", "juan@tabares.com", "123");
        User user2 = new User("Pablo", "Gallego", "pablo@gallego.com", "123");
        User user3 = new User("Sergio", "Garcia", "sergio@garcia.com", "123");

        List<User> users = Arrays.asList(user, user2, user3);

        /* List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3); */

        return users;    
    };

    

}
