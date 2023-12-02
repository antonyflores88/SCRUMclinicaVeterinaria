package sv.edu.ufg.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinarios")
public class Veterinarios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idveterinario;
	private String nombrevet;
	private int citasdisponible;
	private int citareservada;
	private boolean actualizar_citas;
	
	//getter and setter for the attributes.
	

	/**
	 * @return the nombrevet
	 */
	public String getNombrevet() {
		return nombrevet;
	}
	/**
	 * @return the idveterinario
	 */
	public int getIdveterinario() {
		return idveterinario;
	}
	/**
	 * @param idveterinario the idveterinario to set
	 */
	public void setIdveterinario(int idveterinario) {
		this.idveterinario = idveterinario;
	}
	/**
	 * @param nombrevet the nombrevet to set
	 */
	public void setNombrevet(String nombrevet) {
		this.nombrevet = nombrevet;
	}
	/**
	 * @return the citasdisponible
	 */
	public int getCitasdisponible() {
		return citasdisponible;
	}
	/**
	 * @param citasdisponible the citasdisponible to set
	 */
	public void setCitasdisponible(int citasdisponible) {
		this.citasdisponible = citasdisponible;
	}
	/**
	 * @return the citareservada
	 */
	public int getCitareservada() {
		return citareservada;
	}
	/**
	 * @param citareservada the citareservada to set
	 */
	public void setCitareservada(int citareservada) {
		this.citareservada = citareservada;
	}
	/**
	 * @return the actualizar_citas
	 */
	public boolean isActualizar_citas() {
		return actualizar_citas;
	}
	/**
	 * @param actualizar_citas the actualizar_citas to set
	 */
	public void setActualizar_citas(boolean actualizar_citas) {
		this.actualizar_citas = actualizar_citas;
	}
	@Override
	public String toString() {
		return "Veterinarios [idveterinario=" + idveterinario + ", nombrevet=" + nombrevet + ", citasdisponible="
				+ citasdisponible + ", citareservada=" + citareservada + ", actualizar_citas=" + actualizar_citas + "]";
	}
	
	
	

}
