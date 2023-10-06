package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
//las clases controller van a contener metodos de accion o handler
// que van a tener una peticion http del usuario por ejemplo para cargar datos, un estado,
// consultas a la base de datos
@RequestMapping("/app")
public class IndexController {

    //los metodos siempre son publicos
    //este metodo de request es de tipo get, pero tambien se le puede indicar otro tipo de peticion
    //un metodo puede estar mapeado a diferentes rutas
    @GetMapping(path = {"/index", "/", "", "/home" })
    public String index(Model model){
        model.addAttribute("titulo", "hola Spring Framework aaaaaaaaaaaa");
        return "index";
    }

    @RequestMapping(path = "/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Diego");
        usuario.setApellido("Trigos");
        usuario.setEmail("diego.trigos1805@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping(path = "/listar")
    public String listar(Model model){

        model.addAttribute("titulo", "Listado de Usuarios");
        return "listar";
    }

    @ModelAttribute(value = "usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "noriega", "andres@gmail.com"),
                new Usuario("Diego", "Trigos", "diego.trigos1805@gmail.com"),
                new Usuario("Kevin", "Montañez", "kevin@gmail.com"));
        return usuarios;
    }
}
