package sv.edu.ufg.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "examenes")
public class Examenes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_examen")
	private Integer idExamen;
	
	
	@Column(name="tipo_examen")
	private String tipoExamen;
	
	
	@Column(name="especie")
	private String especieAnimal;
	
	
	@Column(name="nombre_ex")
	private String nombreExamen;

	/**
	 * @return the idExamen
	 */
	public Integer getIdExamen() {
		return idExamen;
	}

	/**
	 * @param idExamen the idExamen to set
	 */
	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	/**
	 * @return the tipoExamen
	 */
	public String getTipoExamen() {
		return tipoExamen;
	}

	/**
	 * @param tipoExamen the tipoExamen to set
	 */
	public void setTipoExamen(String tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	/**
	 * @return the especieAnimal
	 */
	public String getEspecieAnimal() {
		return especieAnimal;
	}

	/**
	 * @param especieAnimal the especieAnimal to set
	 */
	public void setEspecieAnimal(String especieAnimal) {
		this.especieAnimal = especieAnimal;
	}

	/**
	 * @return the nombreExamen
	 */
	public String getNombreExamen() {
		return nombreExamen;
	}

	/**
	 * @param nombreExamen the nombreExamen to set
	 */
	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}

	@Override
	public String toString() {
		return "Examenes [idExamen=" + idExamen + ", tipoExamen=" + tipoExamen + ", especieAnimal=" + especieAnimal
				+ ", nombreExamen=" + nombreExamen + "]";
	}
	
	

}
