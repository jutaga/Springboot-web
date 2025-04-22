package com.juanpablo.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juanpablo.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.juanpablo.curso.springboot.webapp.springboot_web.models.dto.ParamsMixedDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "No hay mensaje") String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamsMixedDto bar(@RequestParam String text, @RequestParam Integer code) {
        ParamsMixedDto params = new ParamsMixedDto();
        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    @GetMapping("/request")
    public ParamsMixedDto request(HttpServletRequest request) {
        ParamsMixedDto params = new ParamsMixedDto();
        Integer code = 10;
        try {
            code = Integer.parseInt(request.getParameter("code"));

        } catch (NumberFormatException e) {

            System.out.println("Error al convertir el parametro code a Integer: " + e.getMessage());

        }
        params.setCode(code);
        params.setMessage(request.getParameter("text"));

        return params;
    }
}
