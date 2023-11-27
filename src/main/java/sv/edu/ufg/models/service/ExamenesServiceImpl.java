package sv.edu.ufg.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.edu.ufg.models.entity.Examenes;
import sv.edu.ufg.models.repository.ExamenesRepo;

@Service
public class ExamenesServiceImpl implements ExamenesService {
	
	@Autowired
	private ExamenesRepo examenesRepo;

	@Override
	public List<Examenes> listAll() {
		// TODO Auto-generated method stub
		return (List<Examenes>) examenesRepo.findAll();
	}

	@Override
	public void save(Examenes examenes) {
		// TODO Auto-generated method stub
		examenesRepo.save(examenes);
	}

	@Override
	public Examenes searchById(Integer idExamen) {
		// TODO Auto-generated method stub
		return examenesRepo.findById(idExamen).orElse(null);
	}

	@Override
	public void delete(Integer idExamen) {
		// TODO Auto-generated method stub
		examenesRepo.deleteById(idExamen);
	}

}
