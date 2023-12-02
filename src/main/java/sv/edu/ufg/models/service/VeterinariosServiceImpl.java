package sv.edu.ufg.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.edu.ufg.models.entity.Veterinarios;
import sv.edu.ufg.models.repository.VeterinariosRepository;

@Service
public class VeterinariosServiceImpl implements IVeterinariosService {

	@Autowired
	public VeterinariosRepository veterinariosRepository;
	
	@Override
	public List<Veterinarios> listAll() {
		
		return (List<Veterinarios>) veterinariosRepository.findAll();
	}
	
	@Override
	public void save(Veterinarios veterinarios) {
		veterinariosRepository.save(veterinarios);
	}
	
	@Override
	public Veterinarios searchById(Integer idveterinario) {
		return veterinariosRepository.findById(idveterinario).orElse(null);
	}

}
