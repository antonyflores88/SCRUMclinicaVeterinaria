package sv.edu.ufg.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secretaria")
public class SecretariaController {

	@Secured("SECRETARIA")
	@GetMapping("/logeosecretaria")
    public String mostrarlogeosecretaria() {
        return "views/secretarialist";
    }
	
	@Secured("SECRETARIA")
    @GetMapping("/opciones")
    public String mostrarOpcionesSecretaria() {
        return "views/secretarialist";
    }
}