package sv.edu.ufg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sv.edu.ufg.models.entity.Expediente;
import sv.edu.ufg.models.service.iExpedienteService;

@Controller
@RequestMapping("/views/expedientes")
public class ExpedienteController {
	
	@Autowired
	private iExpedienteService expedienteService;
	
//	@GetMapping("/")
//	public String showExpediente(Model model) {
//		
//		List<Expediente> expedienteList = expedienteService.listAll();
//		
//		model.addAttribute("title", "Expedientes registrados");
//		model.addAttribute("expedientes", expedienteList);
//		
//		return "views/expedientelist";
//	
	@GetMapping("/{id}")
    public String mostrarDetalleExpediente(@PathVariable int id, Model model) {
        // Recuperar el expediente específico por su ID
        Expediente expediente = expedienteService.searchById(id);

        // Pasar el expediente al modelo para que se muestre en la vista
        model.addAttribute("expediente", expediente);

        // Renderizar la vista de detalles de expediente
        return "views/expedientelist";
	
	}
	
	@GetMapping("/create")
	public String crearExpediente() {
		return "views/frmcrearexpediente";
	}

}
