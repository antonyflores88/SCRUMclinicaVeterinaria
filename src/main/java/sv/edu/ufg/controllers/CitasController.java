package sv.edu.ufg.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import sv.edu.ufg.models.entity.Citas;
import sv.edu.ufg.models.entity.Veterinarios;
import sv.edu.ufg.models.service.ICitaService;
import sv.edu.ufg.models.service.IVeterinariosService;

@Controller
@RequestMapping("/views/citas")
public class CitasController {
	
	@Autowired
	private ICitaService citaService;
	
	@Autowired
	private IVeterinariosService veterinarioService;
	
	@PreAuthorize("hasRole('SECRETARIA')")
	@GetMapping("/mostrarcita")
	public String showCitas(Model model) {
		List<Citas> citasdisponibles = citaService.listAll();
		
		model.addAttribute("Titulo", "Listado de Citas");
		model.addAttribute("cita", citasdisponibles);			
		return "views/listadecitas";		
	}
	
	@PreAuthorize("hasRole('SECRETARIA')")
	@GetMapping("/disponibles")
	public String showAvailableSlots(
	    @RequestParam(value = "fecha_cita", required = false) LocalDate fecha_cita,
	    @RequestParam(value = "veterinario_asignado", required = false) Integer veterinario_asignado,
	    Model model) {
		

		if (fecha_cita != null && veterinario_asignado != null) {
		    // Query the database to get all appointments for the selected day and veterinarian
		    List<Citas> bookedAppointments = citaService.getAppointmentsByDateAndVet(fecha_cita, veterinario_asignado);

		    // Generate a list of all available time slots for the day as LocalTime objects
		    List<LocalTime> allTimeSlots = Arrays.asList(
		        LocalTime.of(9, 0),
		        LocalTime.of(10, 0),
		        LocalTime.of(11, 0),
		        LocalTime.of(13, 0),
		        LocalTime.of(14, 0),
		        LocalTime.of(15, 0)
		    );

		    // Generate a list of available time slots by removing booked slots
		    List<LocalTime> availableSlots = new ArrayList<>(allTimeSlots);
		    List<LocalTime> bookedTimes = bookedAppointments.stream()
		        .map(Citas::getHora_cita)
		        .collect(Collectors.toList());
		    availableSlots.removeAll(bookedTimes);
	        System.out.println("Horarios disponibles después de eliminar reservados: " + availableSlots);

	        model.addAttribute("titulo", "Disponibilidad");
	        model.addAttribute("titulo2", "Registro de Citas");
	        model.addAttribute("date", fecha_cita);
	        model.addAttribute("veterinario_asignado", veterinario_asignado);
	        model.addAttribute("fecha_cita", fecha_cita);
	        model.addAttribute("availableSlots", availableSlots);
	        System.out.println("Procesando cita: " + veterinario_asignado);	
	        
	        

	        return "views/listadecitas"; // Muestra resultados
	    }

	    return "views/listadecitas"; // Muestra la vista inicial
	}
	

	@PreAuthorize("hasRole('SECRETARIA')")
	@GetMapping("/crearcita")
	public String crearCita(@RequestParam(name = "veterinario_asignado", required = true) Integer veterinario_asignado, 
			 @RequestParam(name = "fecha", required = true) LocalDate fecha,
             @RequestParam(name = "hora", required = true) LocalTime hora, Model model) {
		  
		// Obtener el expediente que deseo mostrar
		Veterinarios nombreVeterinario = veterinarioService.searchById(veterinario_asignado);
		
		model.addAttribute("fecha", fecha);
	    model.addAttribute("hora", hora);

	    Citas nuevaCita = new Citas();
	    
	    model.addAttribute("title", "Registro de Citas");
	    model.addAttribute("nombreVeterinario", nombreVeterinario);
	    model.addAttribute("citas", nuevaCita);
	    model.addAttribute("btnValue", "Registrar");
	    model.addAttribute("isSave", true);

	    return "views/frmcitas";
	}
    

	@PreAuthorize("hasRole('SECRETARIA')")
	@PostMapping("/save")
	public String saveCita(@Valid @ModelAttribute ("cita") Citas cita,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttr) {

	    
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Registro de Citas");
			model.addAttribute("citas", cita);
			System.out.println("El formulario presenta errores");
			model.addAttribute("btnValue", "Registrar");
			model.addAttribute("isSave", true);
			return "views/frmcitas";
		}
		
		
		citaService.save(cita);

		System.out.println("cita guardada");
		
		redirectAttr.addFlashAttribute("success", "La cita se guardo correctamante");
		
		return "redirect:/secretaria/opciones";
	
	}
	
	@PreAuthorize("hasRole('SECRETARIA')")
	@GetMapping("/buscarcita")
    public String mostrarBusquedaCita() {
        return "views/buscacita";
    }
	
	@PreAuthorize("hasRole('SECRETARIA')")
	@PostMapping("/buscarcita")
	public String buscarCitaporPropietario(@RequestParam("dueno_mascota") String dueno_mascota,
			@RequestParam(value = "fecha_cita", required = false) LocalDate fecha_cita,
			Model model) {
		
		
		if (!dueno_mascota.isEmpty()) {
	        // Search by nombrepropietario
	        List<Citas> citaspornombre = citaService.buscarCitasPorNombrePropietario(dueno_mascota);
	        model.addAttribute("citaspornombre", citaspornombre);
	        
	        if (citaspornombre.isEmpty()) {
	            model.addAttribute("mostrarAlerta", true);
	            System.out.println("mostrarAlerta: true");
	        	}
	        }

    	 else if (fecha_cita != null) {
    	        // Search by nombrepropietario
    		 List<Citas> citasporfecha = citaService.findByFechaCita(fecha_cita);    	        
    		 
    		 model.addAttribute("Citasporfecha", citasporfecha);
    	        
    	        if (citasporfecha.isEmpty()) {
    	            model.addAttribute("mostrarAlerta", true);
    	            System.out.println("mostrarAlerta: true");
    	        	}
    	        }
    	 
        return "views/buscacita";
    }
	
	@PreAuthorize("hasRole('SECRETARIA')")
	 @GetMapping("/cita/{veterinario_asignado}/{idcitas}")
		public String mostrarDetalleExpediente(@PathVariable Integer veterinario_asignado,@PathVariable Integer idcitas, Model model) {
		    // Recuperar la cita
		  System.out.println("ID de la cita: " + idcitas);
		  //Citas nuevaCita = citaService.searchById(idcitas);
		  List<Citas> citas = citaService.findAllCitasById(idcitas);
		   
		  System.out.println("objeto Cita: " + citas.size());
		    
		    Veterinarios nombreVeterinario = veterinarioService.searchById(veterinario_asignado);

		    model.addAttribute("citareservada", citas);
		    model.addAttribute("nombreVeterinario", nombreVeterinario);


		    return "views/cancelacion";
		}
	 
	@PreAuthorize("hasRole('SECRETARIA')")
	 @PostMapping("/cancelarCita")
	 public String cancelarCita(@RequestParam("idcitas") Integer idcitas, RedirectAttributes redirectAttr) {
		
		 citaService.delete(idcitas);
		 redirectAttr.addFlashAttribute("success", "La cita se canceló con éxito");
		 System.out.println("ID de la cita a cancelar: " + idcitas);
		 
	     return "redirect:/secretaria/opciones"; 
	 }
	 
	@PreAuthorize("hasRole('SECRETARIA')")
	 @GetMapping("/edit/{veterinario_asignado}/{idcitas}")
	 public String editarCita(@PathVariable Integer veterinario_asignado,@PathVariable Integer idcitas, RedirectAttributes redirectAttr, 
			 Model model) {
		
		 Veterinarios nombreVeterinario = veterinarioService.searchById(veterinario_asignado);
		 Citas citaeditar = citaService.searchById(idcitas);
		 
		 model.addAttribute("title", "Actualizacion de Cita");
		 model.addAttribute("editarcita", citaeditar);
		 model.addAttribute("nombreVeterinario", nombreVeterinario);
		 model.addAttribute("btnValue", "Actualizar");
		 model.addAttribute("isSave", false);
		 redirectAttr.addFlashAttribute("success", "La cita se modifico con éxito");
		 
	     return "views/frmedicioncitas"; 
	 }
	
}
