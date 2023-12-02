package sv.edu.ufg.models.service;

import java.util.List;

import sv.edu.ufg.models.entity.Examenes;

public interface ExamenesService {

	public List<Examenes> listAll();
	public void save(Examenes examenes);
	public Examenes searchById(Integer idExamen);
	public void delete(Integer idExamen);

}
