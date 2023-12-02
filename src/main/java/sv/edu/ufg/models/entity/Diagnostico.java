package sv.edu.ufg.models.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnosticos")
public class Diagnostico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="diagnosticos")
	private Integer idDiagnostico;
	
	@ManyToOne
    @JoinColumn(name = "Id_vacuna")
    private Vacunas vacuna;
	
	@ManyToOne
    @JoinColumn(name = "Id_examen")
    private Examenes examen;
    

	@Column(name = "idcitas")
    private Integer cita;
	
	@Column(name = "compuesto")
    private String compuesto;
	
	@Column(name="Sintomas")
	private String sintomas;
	
	@Column(name="Nombre_encargado")
	private String encargado;
	
	@Column(name="Fecha_Consulta")
	private LocalDate fechaConsulta;

	/**
	 * @return the idDiagnostico
	 */
	public Integer getIdDiagnostico() {
		return idDiagnostico;
	}

	/**
	 * @param idDiagnostico the idDiagnostico to set
	 */
	public void setIdDiagnostico(Integer idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	/**
	 * @return the vacuna
	 */
	public Vacunas getVacuna() {
		return vacuna;
	}

	/**
	 * @param vacuna the vacuna to set
	 */
	public void setVacuna(Vacunas vacuna) {
		this.vacuna = vacuna;
	}

	/**
	 * @return the examen
	 */
	public Examenes getExamen() {
		return examen;
	}

	/**
	 * @param examen the examen to set
	 */
	public void setExamen(Examenes examen) {
		this.examen = examen;
	}

	/**
	 * @return the cita
	 */
	public Integer getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(Integer cita) {
		this.cita = cita;
	}



	/**
	 * @return the compuesto
	 */
	public String getCompuesto() {
		return compuesto;
	}

	/**
	 * @param compuesto the compuesto to set
	 */
	public void setCompuesto(String compuesto) {
		this.compuesto = compuesto;
	}

	/**
	 * @return the sintomas
	 */
	public String getSintomas() {
		return sintomas;
	}

	/**
	 * @param sintomas the sintomas to set
	 */
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	/**
	 * @return the encargado
	 */
	public String getEncargado() {
		return encargado;
	}

	/**
	 * @param encargado the encargado to set
	 */
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	/**
	 * @return the fechaConsulta
	 */
	public LocalDate getFechaConsulta() {
		return fechaConsulta;
	}

	/**
	 * @param fechaConsulta the fechaConsulta to set
	 */
	public void setFechaConsulta(LocalDate fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	@Override
	public String toString() {
		return "Diagnostico [idDiagnostico=" + idDiagnostico + ", vacuna=" + vacuna + ", examen=" + examen + ", cita="
				+ cita + ", compuesto=" + compuesto + ", sintomas=" + sintomas + ", encargado=" + encargado
				+ ", fechaConsulta=" + fechaConsulta + "]";
	}
	
	
	
}
