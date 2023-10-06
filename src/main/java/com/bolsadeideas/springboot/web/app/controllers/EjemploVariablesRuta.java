package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/variables")
public class EjemploVariablesRuta {

    @GetMapping(path = "/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model){
        model.addAttribute("Titulo", "Recibir parametros de la ruta(@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto +
                "El numero de telefono enviado en el path es: " + numero);
        return "variables/ver";
    }

    
}
