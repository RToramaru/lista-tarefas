package com.contass.lista_tarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * criacao do controlador
 * mapeando ele para o endereco inical localhost:8080/
 * */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "view/index";
    }
}
