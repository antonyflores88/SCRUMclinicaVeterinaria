package sv.edu.ufg.models.service;

import java.util.List;

import sv.edu.ufg.models.entity.Diagnostico;

public interface DiagnosticoService {
	
	public List<Diagnostico> listAll();
	public void save(Diagnostico diagnostico);
	public Diagnostico searchById(Integer idDiagnostico);
	public void delete(Integer idDiagnostico);

}
