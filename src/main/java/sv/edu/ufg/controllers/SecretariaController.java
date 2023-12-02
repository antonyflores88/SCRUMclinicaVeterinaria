package sv.edu.ufg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secretaria")
public class SecretariaController {

    @GetMapping("/opciones")
    public String mostrarOpcionesSecretaria() {
        return "views/secretarialist";
    }
}