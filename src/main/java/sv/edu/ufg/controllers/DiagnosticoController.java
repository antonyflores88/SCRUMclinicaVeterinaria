package sv.edu.ufg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sv.edu.ufg.models.entity.Citas;
import sv.edu.ufg.models.entity.Expediente;
import sv.edu.ufg.models.entity.Diagnostico;
import sv.edu.ufg.models.entity.Examenes;
import sv.edu.ufg.models.entity.Vacunas;
import sv.edu.ufg.models.service.DiagnosticoService;
import sv.edu.ufg.models.service.ExamenesService;
import sv.edu.ufg.models.service.ICitaService;
import sv.edu.ufg.models.service.VacunasService;
import sv.edu.ufg.models.service.iExpedienteService;

@Controller
@RequestMapping("/diagnostico")
public class DiagnosticoController {
	
	@Autowired
	private VacunasService vacunaservicio;
	
	@Autowired
	private ExamenesService examenservicio;
	
	@Autowired
	private DiagnosticoService diagnosticoservice;
	
	@Autowired
	private iExpedienteService expedienteservice;
	
	@Autowired
	private ICitaService citaservice;
	
	
	@GetMapping("/veterinario")
    public String mostrarVeterinarioconsulta() {
        return "views/consulta-veterinario";
    }
	
	@GetMapping("/iniciarconsulta")
    public String mostrarVistaBusqueda() {
        return "views/iniciar-consulta";
    }
	
	@PostMapping("/iniciarconsulta")
	public String buscarExpedientePorId(@RequestParam("idCompuesto") String idCompuesto,
	        @RequestParam(name = "idcitas", required = false) Integer idcitas,Model model) {
		
		if (idCompuesto.isEmpty() || idcitas == null) {
		    // Al menos uno de los campos está vacío, muestra la alerta
		    model.addAttribute("muestraAlerta", true);
		    System.out.println("muestraAlerta: true");
		} else {
		    // Ambos campos tienen valores, realiza las operaciones subsiguientes
		    Expediente expediente = expedienteservice.searchByStringId(idCompuesto);
		    Citas citaEncontrada = citaservice.searchById(idcitas);

		    if (expediente != null && citaEncontrada != null) {
		        // Ambos valores encontrados, puedes agregarlos al modelo
		        model.addAttribute("expediente", expediente);
		        model.addAttribute("cita", citaEncontrada);
		    } else {
		        // Al menos uno de los valores no se encontró, muestra la alerta
		        model.addAttribute("muestraAlerta", true);
		        System.out.println("muestraAlerta: true");
		    }
		}

	    return "views/iniciar-consulta";
	}
	
	
	@GetMapping("/crearconsulta/{idCompuesto}/{idcitas}")
    public String crearConsulta(@PathVariable("idCompuesto") String idcompuesto,@PathVariable("idcitas") Integer idcitas, 
    		Model model) {
	
		Expediente expediente2 = expedienteservice.searchByStringId(idcompuesto);
        Citas citaEncontrada = citaservice.searchById(idcitas);
        
        Vacunas registrarvacuna = new Vacunas();
        Examenes registrarexamen = new Examenes();
        
		Expediente expediente = new Expediente();
	    expediente.setIdCompuesto(idcompuesto);
	    
	    Citas cita = new Citas();
	    cita.setIdcitas(idcitas); 
	    
        Diagnostico nuevodiagnostico = new Diagnostico();
        nuevodiagnostico.setCompuesto(idcompuesto);
        nuevodiagnostico.setCita(idcitas);
        
        model.addAttribute("vacuna", registrarvacuna);
        model.addAttribute("examen", registrarexamen);
        model.addAttribute("expediente", expediente2);
        model.addAttribute("cita", citaEncontrada);
        model.addAttribute("diagnostico", nuevodiagnostico);
        return "views/creacion-consulta";  
		
		}
	
	@PostMapping("/guardarconsulta")
    public String guardarVacunasExamenesDiagnostico(@ModelAttribute("vacunas") Vacunas vacunas,
            @ModelAttribute("examenes") Examenes examenes,@ModelAttribute("diagnostico") Diagnostico diagnostico,
            Model model) {

//	    diagnostico.setCompuesto(idcompuesto);
//	    diagnostico.setCita(idcitas);

        vacunaservicio.save(vacunas);
        examenservicio.save(examenes);
        diagnosticoservice.save(diagnostico);

        model.addAttribute("mostrarAlerta2", true);
        model.addAttribute("mensaje", "Guardado exitosamente");
        
        int idDiagnostico = diagnostico.getIdDiagnostico();
        int idVacuna = vacunas.getIdVacuna();
        int idExamen = examenes.getIdExamen() ;
        
        
        return "redirect:/diagnostico/revisarConsulta?id=" + idDiagnostico + "&idVacuna=" + idVacuna + "&idExamen=" + idExamen;
    }
	
	
	@GetMapping("/revisarConsulta")
	public String revisarConsultaTerminada(@RequestParam Integer id,@RequestParam int idExamen,@RequestParam int idVacuna, Model model) {
		
		Diagnostico diagnostico = diagnosticoservice.searchById(id);
		Examenes examen = examenservicio.searchById(idExamen);
		Vacunas vacuna = vacunaservicio.searchById(idVacuna);
		
		model.addAttribute("diagnostico", diagnostico);
		model.addAttribute("examen", examen);
		model.addAttribute("vacuna", vacuna);
		
		return "views/revision-de-consulta";
	}
	

}
