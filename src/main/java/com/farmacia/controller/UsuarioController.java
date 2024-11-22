package main.java.com.farmacia.controller;

import com.farmacia.model.Usuario;
import com.farmacia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Mostrar formulario para agregar un nuevo usuario
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios"; // Plantilla Thymeleaf para manejar usuarios
    }

    // Crear un nuevo usuario
    @PostMapping("/usuarios/agregar")
    public String agregarUsuario(@RequestParam String nombre, 
                                 @RequestParam String contrasena) {
        usuarioService.crearUsuario(nombre, contrasena);
        return "redirect:/usuarios"; // Redirige a la vista de usuarios
    }
}
