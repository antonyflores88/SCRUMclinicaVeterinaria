package sv.edu.ufg.models.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "vacunas")
public class Vacunas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_vacuna")
	private Integer idVacuna;
	
	
	@Column(name="nombre_vac")
	private String nombreVacuna;
	
	
	@Column(name="especie")
	private String especieAnimal;
	
	
	@Column(name="fecha_ap")
	private LocalDate fechaAplicacion;

	/**
	 * @return the idVacuna
	 */
	public Integer getIdVacuna() {
		return idVacuna;
	}

	/**
	 * @param idVacuna the idVacuna to set
	 */
	public void setIdVacuna(Integer idVacuna) {
		this.idVacuna = idVacuna;
	}

	/**
	 * @return the nombreVacuna
	 */
	public String getNombreVacuna() {
		return nombreVacuna;
	}

	/**
	 * @param nombreVacuna the nombreVacuna to set
	 */
	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
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
	 * @return the fechaAplicacion
	 */
	public LocalDate getFechaAplicacion() {
		return fechaAplicacion;
	}

	/**
	 * @param fechaAplicacion the fechaAplicacion to set
	 */
	public void setFechaAplicacion(LocalDate fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	@Override
	public String toString() {
		return "Vacunas [idVacuna=" + idVacuna + ", nombreVacuna=" + nombreVacuna + ", especieAnimal=" + especieAnimal
				+ ", fechaAplicacion=" + fechaAplicacion + "]";
	}
	
	

}
