package sv.edu.ufg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sv.edu.ufg.models.entity.Expediente;
import sv.edu.ufg.models.service.iExpedienteService;

@Controller
@RequestMapping("/secretaria")
public class MostrarExpedienteController {

    @Autowired
    private iExpedienteService expedienteService;

    // ... Otros métodos del controlador ...
    
    @GetMapping("/buscaexpediente")
    public String mostrarVistaBusqueda() {
        return "views/buscarexpediente";
    }

    @PostMapping("/buscaexpediente")
    public String buscarExpedientePorId(@RequestParam("expedienteId") int expedienteId, Model model) {
        // Realizar la búsqueda del expediente por ID
        Expediente expediente = expedienteService.searchById(expedienteId);

        // Pasar el expediente al modelo para mostrar los resultados
        model.addAttribute("expediente", expediente);

        // Redirigir a la vista "expedientelist.html" para mostrar los resultados
        return "views/buscarexpediente";
    }
}
