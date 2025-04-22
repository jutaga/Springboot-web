package com.juanpablo.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.juanpablo.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Juan", "Tabares", "", "123");

        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("userInfo", user);
        return "details";
    }

    /**
     * @GetMapping("/details")
     * public String details(Map <String, Object> model) {
     * model.put("title", "Hola mundo Spring Boot");
     * model.put("userName", "Juan pablo");
     * model.put("userLastName", "Tabares");
     * return "details";
     * }
     */

    @GetMapping("/list")
    public String list(ModelMap model) {

        model.addAttribute("title", "Lista de usuarios");

        return "list";
    }
    
    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
                new User("Juan", "Tabares", "", "123"),
                new User("Pablo", "Gallego", "email@email.com", "123"),
                new User("Juan Pablo", "Tabares", "", "123"));

    }

}
