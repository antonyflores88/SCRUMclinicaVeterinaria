package sv.edu.ufg.models.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sv.edu.ufg.models.entity.Citas;

public interface CitasRepository extends CrudRepository<Citas, Integer> {
	
	@Query("SELECT c FROM Citas c WHERE c.fecha_cita = :fechaCita AND c.veterinario_asignado = :veterinarioAsignado")
    List<Citas> findByFechaCitaAndVeterinarioAsignado(@Param("fechaCita") LocalDate fechaCita, @Param("veterinarioAsignado") Integer veterinarioAsignado);
	
	// Define a custom query method to search by "dueno_mascota"
	@Query("SELECT c FROM Citas c WHERE c.dueno_mascota LIKE %:dueno_mascota%")
    List<Citas> findByNombrepropietarioIgnoreCaseContaining(@Param("dueno_mascota") String dueno_mascota);
	
	@Query("SELECT c FROM Citas c WHERE c.idcitas = :idcitas")
	List<Citas> findAllById(@Param("idcitas") Integer idcitas);
	
	@Query("SELECT c FROM Citas c WHERE c.fecha_cita = :fecha_cita")
    List<Citas> findByFechaCita(@Param("fecha_cita") LocalDate fecha_cita);
}
