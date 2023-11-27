package sv.edu.ufg.models.service;

import java.time.LocalDate;
import java.util.List;

import sv.edu.ufg.models.entity.Citas;


public interface ICitaService {
	
	public List<Citas> listAll();
	public void save(Citas citas);
	public Citas searchById(Integer idcita);
	public void delete(Integer idcita);
	List<Citas> getAppointmentsByDateAndVet(LocalDate fecha_cita, Integer veterinario_asignado);
	
	List<Citas> buscarCitasPorNombrePropietario(String dueno_mascota);
	
	public List<Citas> findAllCitasById(Integer idcitas);
	
	List<Citas> findByFechaCita(LocalDate fecha_cita);
	
}
