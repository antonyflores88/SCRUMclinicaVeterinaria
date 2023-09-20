package sv.edu.ufg.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expediente")
public class Expediente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int expedienteid;
	private String nombrepaciente;
	private String nombrepropietario;
	private String especie;
	private String sexo;
	private String raza;
	private String color;
	private String direccion;
	private String telefono;
	private String medicoreferido;
	private int idcompuesto;
	
	//Metodos consultores y modificadores.
	/**
	 * @return the expedienteid
	 */
	public int getExpedienteid() {
		return expedienteid;
	}
	/**
	 * @param expedienteid the expedienteid to set
	 */
	public void setExpedienteid(int expedienteid) {
		this.expedienteid = expedienteid;
	}
	/**
	 * @return the nombrepaciente
	 */
	public String getNombrepaciente() {
		return nombrepaciente;
	}
	/**
	 * @param nombrepaciente the nombrepaciente to set
	 */
	public void setNombrepaciente(String nombrepaciente) {
		this.nombrepaciente = nombrepaciente;
	}
	/**
	 * @return the nombrepropietario
	 */
	public String getNombrepropietario() {
		return nombrepropietario;
	}
	/**
	 * @param nombrepropietario the nombrepropietario to set
	 */
	public void setNombrepropietario(String nombrepropietario) {
		this.nombrepropietario = nombrepropietario;
	}
	/**
	 * @return the especie
	 */
	public String getEspecie() {
		return especie;
	}
	/**
	 * @param especie the especie to set
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the raza
	 */
	public String getRaza() {
		return raza;
	}
	/**
	 * @param raza the raza to set
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the medicoreferido
	 */
	public String getMedicoreferido() {
		return medicoreferido;
	}
	/**
	 * @param medicoreferido the medicoreferido to set
	 */
	public void setMedicoreferido(String medicoreferido) {
		this.medicoreferido = medicoreferido;
	}
	/**
	 * @return the idcompuesto
	 */
	public int getIdcompuesto() {
		return idcompuesto;
	}
	/**
	 * @param idcompuesto the idcompuesto to set
	 */
	public void setIdcompuesto(int idcompuesto) {
		this.idcompuesto = idcompuesto;
	}
	@Override
	public String toString() {
		return "Expediente [expedienteid=" + expedienteid + ", nombrepaciente=" + nombrepaciente
				+ ", nombrepropietario=" + nombrepropietario + ", especie=" + especie + ", sexo=" + sexo + ", raza="
				+ raza + ", color=" + color + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", medicoreferido=" + medicoreferido + ", idcompuesto=" + idcompuesto + "]";
	}
	
	
	
}
