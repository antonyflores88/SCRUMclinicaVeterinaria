package sv.edu.ufg.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "expediente")
public class Expediente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "expedienteid")
	private int expedienteid;
	
	@NotEmpty(message="El nombre de la mascota es requerido")
	@Column(name = "nombre_mascota")
	private String nombrepaciente;
	
	@NotEmpty(message="El nombre del propietario es requerido")
	@Column(name = "nombre_propietario")
	private String nombrepropietario;
	
	@NotEmpty(message="El campo 'especie' es requerido")
	private String especie;
	@NotEmpty(message="El campo 'sexo' es requerido")
	private String sexo;
	@NotEmpty(message="El campo 'raza' es requerido")
	private String raza;
	@NotEmpty(message="El campo 'color' es requerido")
	private String color;
	@NotEmpty(message="El campo 'direccion' es requerido")
	private String direccion;
	
	@NotEmpty(message="Debe ingresar un numero telefonico")
	private String telefono;
	
	private String medicoreferido;
	
	@Id
	@NotEmpty(message="Presione 'Generar ID' para llenar este campo")
	@Column(name = "id_compuesto")
    private String idCompuesto;
	

	/**
	 * @return the idCompuesto
	 */
	public String getIdCompuesto() {
		return idCompuesto;
	}
	/**
	 * @param idCompuesto the idCompuesto to set
	 */
	public void setIdCompuesto(String idCompuesto) {
		this.idCompuesto = idCompuesto;
	}
	
	
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

	
	
	@Override
	public String toString() {
		return "Expediente [expedienteid=" + expedienteid + ", nombrepaciente=" + nombrepaciente
				+ ", nombrepropietario=" + nombrepropietario + ", especie=" + especie + ", sexo=" + sexo + ", raza="
				+ raza + ", color=" + color + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", medicoreferido=" + medicoreferido + ", idCompuesto=" + idCompuesto + "]";
	}
	
	
	
}
