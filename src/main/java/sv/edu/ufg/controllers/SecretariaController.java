package sv.edu.ufg.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secretaria")
public class SecretariaController {

	@PreAuthorize("hasRole('SECRETARIA')")
	@GetMapping("/logeosecretaria")
    public String mostrarlogeosecretaria() {
        return "views/home-secretaria";
    }
	
	@PreAuthorize("hasRole('SECRETARIA')")
    @GetMapping("/opciones")
    public String mostrarOpcionesSecretaria() {
        return "views/secretarialist";
    }
}