package sv.edu.ufg.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.ufg.models.entity.Diagnostico;
import sv.edu.ufg.models.repository.DiagnosticoRepo;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {
	
	@Autowired
	private DiagnosticoRepo diagnosticoRepo;

	@Override
	public List<Diagnostico> listAll() {
		// TODO Auto-generated method stub
		return (List<Diagnostico>) diagnosticoRepo.findAll();
	}

	@Transactional
	public void save(Diagnostico diagnostico) {
		// TODO Auto-generated method stub
		diagnosticoRepo.save(diagnostico);
	}

	@Override
	public Diagnostico searchById(Integer idDiagnostico) {
		// TODO Auto-generated method stub
		return diagnosticoRepo.findById(idDiagnostico).orElse(null);
	}

	@Override
	public void delete(Integer idDiagnostico) {
		// TODO Auto-generated method stub
		diagnosticoRepo.deleteById(idDiagnostico);
	}

}
