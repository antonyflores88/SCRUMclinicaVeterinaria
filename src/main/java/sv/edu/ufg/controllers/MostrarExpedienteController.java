package sv.edu.ufg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String buscarExpedientePorId(@RequestParam("idCompuesto") String idCompuesto,@RequestParam("nombrepropietario") String nombrePropietario,@RequestParam("nombrepaciente") String nombrePaciente, Model model) {
    	 if (!idCompuesto.isEmpty()) {
    	        // Search by ID
    	        Expediente expediente = expedienteService.searchByStringId(idCompuesto);
    	        model.addAttribute("expediente", expediente);
    	    }

    	 else if (!nombrePropietario.isEmpty()) {
    	        // Search by nombrepropietario
    	        List<Expediente> expedientesPorNombrePropietario = expedienteService.searchByNombrePropietario(nombrePropietario);
    	        model.addAttribute("expedientesPorNombrePropietario", expedientesPorNombrePropietario);
    	        
    	        if (expedientesPorNombrePropietario.isEmpty()) {
    	            model.addAttribute("mostrarAlerta", true);
    	            System.out.println("mostrarAlerta: true");
    	        	}
    	  
    	        }
    	 else if (!nombrePaciente.isEmpty()) {
    	        // Search by nombrepaciente
    	        List<Expediente> expedientesPorNombrePaciente = expedienteService.buscarPorNombrePaciente(nombrePaciente);
    	        model.addAttribute("expedientesPorNombrePaciente", expedientesPorNombrePaciente);

    	        if (expedientesPorNombrePaciente.isEmpty()) {
    	            model.addAttribute("mostrarAlerta", true);
    	            System.out.println("mostrarAlerta: true");
    	        }
    	    }
    	 
        return "views/buscarexpediente";
    }
    
    @GetMapping("/expediente/{idCompuesto}")
   	public String mostrarDetalleExpediente(@PathVariable String idCompuesto, Model model) {
   	    // Recuperar el expediente específico por su ID
   	    Expediente expediente = expedienteService.searchByStringId(idCompuesto);

   	    // Verificar si el expediente existe
   	    if (expediente == null) {
   	        // Manejar el caso en el que el expediente no se encuentra (puedes redirigir a una página de error, por ejemplo)
   	        return "redirect:/error";
   	    }

   	    // Pasar el expediente al modelo para que se muestre en la vista de detalles
   	    model.addAttribute("expediente", expediente);

   	    // Renderizar la vista de detalles de expediente (por ejemplo, detalles_expediente.html)
   	    return "views/expedientelist";
   	}
   
}
