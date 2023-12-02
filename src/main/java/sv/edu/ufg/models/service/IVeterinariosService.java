package sv.edu.ufg.models.service;

import java.util.List;

import sv.edu.ufg.models.entity.Veterinarios;

public interface IVeterinariosService {
	
	public List<Veterinarios> listAll();
	public void save(Veterinarios veterinarios); 
	public Veterinarios searchById(Integer idcita);
}
