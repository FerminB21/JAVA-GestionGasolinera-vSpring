package com.GestionGasolinera.dtos;

import java.util.Objects;

public class CombustibleDTO {

	/******************************************* ATRIBUTOS *********************************************/
	private long combustible_id;
	private String repostajeVehiculo_uuid;
	private String combustible_nombre;
	private double combustible_precio;
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	public CombustibleDTO(long combustible_id, String repostajeVehiculo_uuid, String combustible_nombre,
			double combustible_precio) {
		super();
		this.combustible_id = combustible_id;
		this.repostajeVehiculo_uuid = repostajeVehiculo_uuid;
		this.combustible_nombre = combustible_nombre;
		this.combustible_precio = combustible_precio;
	}
	
	public CombustibleDTO() {
		super();
	}

	
	/******************************************* GETTER Y SETTERS *********************************************/
	public long getCombustible_id() {
		return combustible_id;
	}

	public void setCombustible_id(long combustible_id) {
		this.combustible_id = combustible_id;
	}

	public String getRepostajeVehiculo_uuid() {
		return repostajeVehiculo_uuid;
	}

	public void setRepostajeVehiculo_uuid(String repostajeVehiculo_uuid) {
		this.repostajeVehiculo_uuid = repostajeVehiculo_uuid;
	}

	public String getCombustible_nombre() {
		return combustible_nombre;
	}

	public void setCombustible_nombre(String combustible_nombre) {
		this.combustible_nombre = combustible_nombre;
	}

	public double getCombustible_precio() {
		return combustible_precio;
	}

	public void setCombustible_precio(double combustible_precio) {
		this.combustible_precio = combustible_precio;
	}

	
	/******************************************* MÉTODOS *********************************************/

	
	/******************************************* HashCode y Equals ***********************************/
	@Override
	public int hashCode() {
		return Objects.hash(combustible_id, combustible_nombre, combustible_precio, repostajeVehiculo_uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CombustibleDTO other = (CombustibleDTO) obj;
		return combustible_id == other.combustible_id && Objects.equals(combustible_nombre, other.combustible_nombre)
				&& Double.doubleToLongBits(combustible_precio) == Double.doubleToLongBits(other.combustible_precio)
				&& Objects.equals(repostajeVehiculo_uuid, other.repostajeVehiculo_uuid);
	}

	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "CombustibleDTO [" + 
					"combustible_id=" + combustible_id + 
					", repostajeVehiculo_uuid=" + repostajeVehiculo_uuid + 
					", combustible_nombre=" + combustible_nombre + 
					", combustible_precio=" + combustible_precio + 
				"]";
	}
	
}