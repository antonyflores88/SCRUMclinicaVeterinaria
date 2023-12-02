package sv.edu.ufg.models.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "citas")
public class Citas {
	
	@Id
	@Column(name = "idcitas", nullable = false)
	private int idcitas;
	
	//@NotEmpty(message = "El nombre es necesario")
	@Column(name = "dueno_mascota")
	private String dueno_mascota;
	private int veterinario_asignado;
	private LocalDate fecha_cita;
	private LocalTime hora_cita;
	



	/**
	 * @return the idcitas
	 */
	public int getIdcitas() {
		return idcitas;
	}

	/**
	 * @param idcitas the idcitas to set
	 */
	public void setIdcitas(int idcitas) {
		this.idcitas = idcitas;
	}

	/**
	 * @return the dueno_mascota
	 */
	public String getDueno_mascota() {
		return dueno_mascota;
	}

	/**
	 * @param dueno_mascota the dueno_mascota to set
	 */
	public void setDueno_mascota(String dueno_mascota) {
		this.dueno_mascota = dueno_mascota;
	}



	/**
	 * @return the veterinario_asignado
	 */
	public int getVeterinario_asignado() {
		return veterinario_asignado;
	}

	/**
	 * @param veterinario_asignado the veterinario_asignado to set
	 */
	public void setVeterinario_asignado(int veterinario_asignado) {
		this.veterinario_asignado = veterinario_asignado;
	}

	/**
	 * @return the fecha_cita
	 */
	public LocalDate getFecha_cita() {
		return fecha_cita;
	}

	/**
	 * @param fecha_cita the fecha_cita to set
	 */
	public void setFecha_cita(LocalDate fecha_cita) {
		this.fecha_cita = fecha_cita;
	}

	/**
	 * @return the hora_cita
	 */
	public LocalTime getHora_cita() {
		return hora_cita;
	}

	/**
	 * @param hora_cita the hora_cita to set
	 */
	public void setHora_cita(LocalTime hora_cita) {
		this.hora_cita = hora_cita;
	}

//	/**
//	 * @return the veterinarios
//	 */
//	public Veterinarios getVeterinarios() {
//		return veterinarios;
//	}
//
//	/**
//	 * @param veterinarios the veterinarios to set
//	 */
//	public void setVeterinarios(Veterinarios veterinarios) {
//		this.veterinarios = veterinarios;
//	}

	@Override
	public String toString() {
		return "Citas [idcitas=" + idcitas + ", dueno_mascota=" + dueno_mascota + ", veterinario_asignado="
				+ veterinario_asignado + ", fecha_cita=" + fecha_cita + ", hora_cita=" + hora_cita + "]";
	}
	
	

}
