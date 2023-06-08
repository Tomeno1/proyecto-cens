package com.proyectcens.springbootcens.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class AccesoUsuarioControlador {
    @Controller
public class UserController {

    @GetMapping("/admin")
    public String adminView() {
        return "admin-view";
    }

    @GetMapping("/user")
    public String userView() {
        return "user-view";
    }

    @GetMapping("/gestor")
    public String gestorView() {
        return "gestor-view";
    }
}

}
