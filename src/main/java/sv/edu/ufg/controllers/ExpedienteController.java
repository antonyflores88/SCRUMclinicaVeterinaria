package sv.edu.ufg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import sv.edu.ufg.models.entity.Expediente;
import sv.edu.ufg.models.service.iExpedienteService;

@Controller
@RequestMapping("/views/expedientes")
public class ExpedienteController {
	
	@Autowired
	private iExpedienteService expedienteService;
	
	
	@GetMapping("/create")
	public String crearExpediente(Model model) {
		
		Expediente expedientitoanimal = new Expediente();
		  	
		model.addAttribute("title", "Registro de Mascotas");
		model.addAttribute("expediente", expedientitoanimal);
		model.addAttribute("btnValue", "Registro");
		model.addAttribute("isSave", true);
		
		return "views/frmcrearexpediente";
	}
	
	@PostMapping("/save")
	public String saveExpediente(@Valid @ModelAttribute ("expediente") Expediente expediente, 
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttr) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Registro de Mascotas");
			model.addAttribute("expediente", expediente);
			System.out.println("El formulario presenta errores");
			model.addAttribute("btnValue", "Registro");
			model.addAttribute("isSave", false);
			return "views/frmcrearexpediente";
		}
		
		expedienteService.save(expediente);

		System.out.println("animal guardado");
		
		redirectAttr.addFlashAttribute("success", "El expediente se guardo correctamante");
		
		return "redirect:/secretaria/opciones";
	
	}
	
	@GetMapping("/edit/{idCompuesto}")
	public String showEditForm(@PathVariable("idCompuesto") String idcompuesto, Model model) {
	    // Obtener el expediente que deseas editar
	    Expediente expedientitoanimal = expedienteService.searchByStringId(idcompuesto);

	    // Llenar el modelo con los datos del expediente
	    model.addAttribute("title", "Actualizacion de Mascota");
	    model.addAttribute("expediente", expedientitoanimal);
	    model.addAttribute("btnValue", "Actualizar");
	    model.addAttribute("isSave", false);

		
		return "views/frmedicion";
	}

}
