package sv.edu.ufg.models.service;

import java.util.List;

import sv.edu.ufg.models.entity.Vacunas;

public interface VacunasService {


	public List<Vacunas> listAll();
	public void save(Vacunas vacunas);
	public Vacunas searchById(Integer idVacuna);
	public void delete(Integer idVacuna);
	
}
