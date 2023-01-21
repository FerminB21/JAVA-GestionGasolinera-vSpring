package com.GestionGasolinera.dtos;

import java.util.Date;
import java.util.Objects;

import com.GestionGasolinera.entities.Combustible;


public class RepostajeVehiculoDTO {

	/******************************************* ATRIBUTOS *********************************************/
	private long repostajeVehiculo_id;
	private String repostajeVehiculo_uuid;
	private Date repostajeVehiculo_date;
	private String repostajeVehiculo_dni;
	private String repostajeVehiculo_matricula;
	private double repostajeVehiculo_litros;
	private String repostajeVehiculo_combustible;
	private double repostajeVehiculo_importeTotal;
	
	/******************************************* RELACIONES *********************************************/
	private Combustible combustible;

	
	/******************************************* CONSTRUCTORES *********************************************/
	public RepostajeVehiculoDTO(
		long repostajeVehiculo_id, 
		String repostajeVehiculo_uuid, 
		Date repostajeVehiculo_date,
		String repostajeVehiculo_dni, 
		String repostajeVehiculo_matricula, 
		double repostajeVehiculo_litros,
		String repostajeVehiculo_combustible, 
		double repostajeVehiculo_importeTotal, 
		Combustible combustible
	) {
		super();
		this.repostajeVehiculo_id = repostajeVehiculo_id;
		this.repostajeVehiculo_uuid = repostajeVehiculo_uuid;
		this.repostajeVehiculo_date = repostajeVehiculo_date;
		this.repostajeVehiculo_dni = repostajeVehiculo_dni;
		this.repostajeVehiculo_matricula = repostajeVehiculo_matricula;
		this.repostajeVehiculo_litros = repostajeVehiculo_litros;
		this.repostajeVehiculo_combustible = repostajeVehiculo_combustible;
		this.repostajeVehiculo_importeTotal = repostajeVehiculo_importeTotal;
		this.combustible = combustible;
	}

	public RepostajeVehiculoDTO() {
		super();
	}

	
	/******************************************* GETTER Y SETTERS *********************************************/
	public long getRepostajeVehiculo_id() {
		return repostajeVehiculo_id;
	}

	public void setRepostajeVehiculo_id(long repostajeVehiculo_id) {
		this.repostajeVehiculo_id = repostajeVehiculo_id;
	}

	public String getRepostajeVehiculo_uuid() {
		return repostajeVehiculo_uuid;
	}

	public void setRepostajeVehiculo_uuid(String repostajeVehiculo_uuid) {
		this.repostajeVehiculo_uuid = repostajeVehiculo_uuid;
	}

	public Date getRepostajeVehiculo_date() {
		return repostajeVehiculo_date;
	}

	public void setRepostajeVehiculo_date(Date repostajeVehiculo_date) {
		this.repostajeVehiculo_date = repostajeVehiculo_date;
	}

	public String getRepostajeVehiculo_dni() {
		return repostajeVehiculo_dni;
	}

	public void setRepostajeVehiculo_dni(String repostajeVehiculo_dni) {
		this.repostajeVehiculo_dni = repostajeVehiculo_dni;
	}

	public String getRepostajeVehiculo_matricula() {
		return repostajeVehiculo_matricula;
	}

	public void setRepostajeVehiculo_matricula(String repostajeVehiculo_matricula) {
		this.repostajeVehiculo_matricula = repostajeVehiculo_matricula;
	}

	public double getRepostajeVehiculo_litros() {
		return repostajeVehiculo_litros;
	}

	public void setRepostajeVehiculo_litros(double repostajeVehiculo_litros) {
		this.repostajeVehiculo_litros = repostajeVehiculo_litros;
	}

	public String getRepostajeVehiculo_combustible() {
		return repostajeVehiculo_combustible;
	}

	public void setRepostajeVehiculo_combustible(String repostajeVehiculo_combustible) {
		this.repostajeVehiculo_combustible = repostajeVehiculo_combustible;
	}

	public double getRepostajeVehiculo_importeTotal() {
		return repostajeVehiculo_importeTotal;
	}

	public void setRepostajeVehiculo_importeTotal(double repostajeVehiculo_importeTotal) {
		this.repostajeVehiculo_importeTotal = repostajeVehiculo_importeTotal;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}
	
	
	/******************************************* MÉTODOS *********************************************/

	
	/******************************************* HashCode y Equals ***********************************/
	@Override
	public int hashCode() {
		return Objects.hash(combustible, repostajeVehiculo_combustible, repostajeVehiculo_date, repostajeVehiculo_dni,
				repostajeVehiculo_id, repostajeVehiculo_importeTotal, repostajeVehiculo_litros,
				repostajeVehiculo_matricula, repostajeVehiculo_uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepostajeVehiculoDTO other = (RepostajeVehiculoDTO) obj;
		return Objects.equals(combustible, other.combustible)
				&& Objects.equals(repostajeVehiculo_combustible, other.repostajeVehiculo_combustible)
				&& Objects.equals(repostajeVehiculo_date, other.repostajeVehiculo_date)
				&& Objects.equals(repostajeVehiculo_dni, other.repostajeVehiculo_dni)
				&& repostajeVehiculo_id == other.repostajeVehiculo_id
				&& Double.doubleToLongBits(repostajeVehiculo_importeTotal) == Double
						.doubleToLongBits(other.repostajeVehiculo_importeTotal)
				&& Double.doubleToLongBits(repostajeVehiculo_litros) == Double
						.doubleToLongBits(other.repostajeVehiculo_litros)
				&& Objects.equals(repostajeVehiculo_matricula, other.repostajeVehiculo_matricula)
				&& Objects.equals(repostajeVehiculo_uuid, other.repostajeVehiculo_uuid);
	}

	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "RepostajeVehiculoDTO [" + 
					"repostajeVehiculo_id=" + repostajeVehiculo_id + 
					", repostajeVehiculo_uuid=" + repostajeVehiculo_uuid + 
					", repostajeVehiculo_date=" + repostajeVehiculo_date + 
					", repostajeVehiculo_dni=" + repostajeVehiculo_dni + 
					", repostajeVehiculo_matricula=" + repostajeVehiculo_matricula + 
					", repostajeVehiculo_litros=" + repostajeVehiculo_litros + 
					", repostajeVehiculo_combustible=" + repostajeVehiculo_combustible + 
					", repostajeVehiculo_importeTotal=" + repostajeVehiculo_importeTotal + 
					", combustible=" + combustible
				+ "]";
	}
	
}