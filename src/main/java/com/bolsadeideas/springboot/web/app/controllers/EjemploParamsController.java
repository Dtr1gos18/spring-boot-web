package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/params")
public class EjemploParamsController {

    @GetMapping(path = "/")
    public String index(){


        return "params/index";
    }

    @GetMapping(path = "/string")
    public String param(@RequestParam (required = false) String texto, Model model){

        model.addAttribute("resultado", "El texto enviado es: " + texto);
        return "params/ver";
    }

    @GetMapping(path = "/mix")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){

        model.addAttribute("resultado", "El saludo enviado es: " + saludo + "Numero de telefono: " + numero);
        return "params/ver";
    }

    @GetMapping(path = "/mix-http")
    public String param(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            numero=0;
        }
        model.addAttribute("resultado", "El saludo enviado es: " + saludo + "Numero de telefono: " + numero);
        return "params/ver";
    }
}
