package sv.edu.ufg.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sv.edu.ufg.models.entity.Expediente;

public interface ExpedienteRepository extends CrudRepository<Expediente, Integer> {

	Expediente findByIdCompuesto(String idCompuesto);
	
	// Define a custom query method to search by "nombrepropietario"
    @Query("SELECT e FROM Expediente e WHERE e.nombrepropietario LIKE %:nombrepropietario%")
    List<Expediente> findByNombrepropietarioIgnoreCaseContaining(@Param("nombrepropietario") String nombrepropietario);
    
 // Nuevo método de búsqueda por nombrepaciente
    @Query("SELECT e FROM Expediente e WHERE e.nombrepaciente LIKE %:nombrepaciente%")
    List<Expediente> findByNombrepacienteIgnoreCaseContaining(@Param("nombrepaciente") String nombrepaciente);

}
