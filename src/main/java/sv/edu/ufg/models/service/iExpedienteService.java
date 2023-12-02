package sv.edu.ufg.models.service;

import java.util.List;

import sv.edu.ufg.models.entity.Expediente;


public interface iExpedienteService {
	
	public List<Expediente> listAll();
	public void save(Expediente expediente);
	public Expediente searchById(Integer ExpedienteID);
	public void delete(Integer ExpedienteID);
	
	public Expediente searchByStringId(String idCompuesto);
	
	List<Expediente> searchByNombrePropietario(String nombrepropietario);
	
	List<Expediente> buscarPorNombrePaciente(String nombrepaciente);

}
