package sv.edu.ufg.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.edu.ufg.models.entity.Vacunas;
import sv.edu.ufg.models.repository.VacunasRepo;

@Service
public class VacunasServiceImpl implements VacunasService {
	
	@Autowired
	private VacunasRepo vacunasRepo;

	@Override
	public List<Vacunas> listAll() {
		// TODO Auto-generated method stub
		return (List<Vacunas>) vacunasRepo.findAll();
	}

	@Override
	public void save(Vacunas vacunas) {
		// TODO Auto-generated method stub
		vacunasRepo.save(vacunas);
	}

	@Override
	public Vacunas searchById(Integer idVacuna) {
		// TODO Auto-generated method stub
		return vacunasRepo.findById(idVacuna).orElse(null);
	}

	@Override
	public void delete(Integer idVacuna) {
		// TODO Auto-generated method stub
		vacunasRepo.deleteById(idVacuna);
	}

}
