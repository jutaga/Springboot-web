package com.juanpablo.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanpablo.curso.springboot.webapp.springboot_web.models.User;
import com.juanpablo.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> listOfValues2;

    @Value("#{'${config.listOfValues}'}")
    private String listOfValuesString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        // Hacer algo con el usuario , save en la bbdd
        return user;
    }

    @GetMapping("/config")
    public Map<String, Object> config() {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("username2", environment.getProperty("config.username"));
        json.put("listOfValues", listOfValues);
        json.put("listOfValues2", listOfValues2);
        json.put("listOfValuesString", listOfValuesString);
        json.put("valuesMap", valuesMap);
        json.put("code", code);
        json.put("code2", environment.getProperty("config.code", Long.class));
        return json;
    }

}
