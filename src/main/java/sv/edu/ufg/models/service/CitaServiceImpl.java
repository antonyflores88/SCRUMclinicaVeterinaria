package sv.edu.ufg.models.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.edu.ufg.models.entity.Citas;
import sv.edu.ufg.models.repository.CitasRepository;

@Service
public class CitaServiceImpl implements ICitaService {

	@Autowired
	private CitasRepository citasRepository;
	
	@Override
	public List<Citas> listAll() {
		return (List<Citas>) citasRepository.findAll();
	}

	@Override
	public void save(Citas citas) {
		citasRepository.save(citas);
	}

	@Override
	public Citas searchById(Integer idcita) {
		return citasRepository.findById(idcita).orElse(null);
	}

	@Override
	public void delete(Integer idcita) {
		citasRepository.deleteById(idcita);
	}
	
	
	 @Override
	    public List<Citas> getAppointmentsByDateAndVet(LocalDate fecha_cita, Integer veterinario_asignado) {
	        // Implement the query to retrieve appointments based on fechaCita and veterinarioAsignado
	        return citasRepository.findByFechaCitaAndVeterinarioAsignado(fecha_cita, veterinario_asignado);
	    }
	
	 // Método para buscar citas por el nombre del propietario
	    @Override
	    public List<Citas> buscarCitasPorNombrePropietario(String dueno_mascota) {
	        return citasRepository.findByNombrepropietarioIgnoreCaseContaining(dueno_mascota);
	    }
	    
	    @Override
	    public List<Citas> findAllCitasById(Integer idcitas) {
	    	  return citasRepository.findAllById(idcitas); 
	    	}
	    
	    @Override
	    public List<Citas> findByFechaCita(LocalDate fecha_cita) {
	        return citasRepository.findByFechaCita(fecha_cita);
	    }

}
