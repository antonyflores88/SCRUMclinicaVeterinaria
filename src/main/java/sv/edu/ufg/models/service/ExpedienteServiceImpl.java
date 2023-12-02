package sv.edu.ufg.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.edu.ufg.models.entity.Expediente;
import sv.edu.ufg.models.repository.ExpedienteRepository;

@Service
public class ExpedienteServiceImpl implements iExpedienteService {

	@Autowired
	private ExpedienteRepository expedienteRepository;
	
	@Override
	public List<Expediente> listAll() {
		// TODO Auto-generated method stub
		return (List<Expediente>) expedienteRepository.findAll();
	}

	@Override
	public void save(Expediente expediente) {
		// TODO Auto-generated method stub
		expedienteRepository.save(expediente);
	}

	@Override
	public Expediente searchById(Integer ExpedienteID) {
		// TODO Auto-generated method stub
		return expedienteRepository.findById(ExpedienteID).orElse(null);
	}
	
	@Override
    public Expediente searchByStringId(String idCompuesto) {
        // Implement your custom query here
        // Assuming that idCompuesto is a unique identifier
        return expedienteRepository.findByIdCompuesto(idCompuesto);
    }

	@Override
	public void delete(Integer ExpedienteID) {
		// TODO Auto-generated method stub
		expedienteRepository.deleteById(ExpedienteID);
	}

	@Override
	public List<Expediente> searchByNombrePropietario(String nombrepropietario) {
		// TODO Auto-generated method stub
		return expedienteRepository.findByNombrepropietarioIgnoreCaseContaining(nombrepropietario);
	}
	
	@Override
    public List<Expediente> buscarPorNombrePaciente(String nombrepaciente) {
        // Implementación del método
        return expedienteRepository.findByNombrepacienteIgnoreCaseContaining(nombrepaciente);
    }

}
