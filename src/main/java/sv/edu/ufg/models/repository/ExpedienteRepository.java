package sv.edu.ufg.models.repository;

import org.springframework.data.repository.CrudRepository;

import sv.edu.ufg.models.entity.Expediente;

public interface ExpedienteRepository extends CrudRepository<Expediente, Integer> {

}
