package com.juanpablo.curso.springboot.webapp.springboot_web.controllers;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juanpablo.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Juan", "Tabares", "juan@tabares.com", "123");

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
}
