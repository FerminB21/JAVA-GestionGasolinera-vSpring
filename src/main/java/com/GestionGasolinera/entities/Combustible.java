package com.GestionGasolinera.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "dwh_gg_combustibles", schema = "dwh_gestion_gasolinera")
public class Combustible implements Serializable {

	private static final long serialVersionUID = 1L;

	
	/******************************************* ATRIBUTOS *********************************************/
	@Id
	@Column(name = "combustible_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long combustible_id;
/*
	@Column(name = "combustible_uuid", unique = false, nullable = false)
	private String repostajeVehiculo_uuid;
*/
	@Column(name = "combustible_nombre", unique = false, nullable = false, length = 11) // con una longitud de 11 se podría llegar a escribir como máximo Gasolina 95 o Gasolina 98
	private String combustible_nombre;
	
	@Column(name = "combustible_precio", unique = false, nullable = false)
	private double combustible_precio;

	
	/******************************************* RELACIONES *********************************************/
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno, y el uuid lo relleno en el dto con un método
	public Combustible(String combustible_nombre, double combustible_precio) {
		super();
		this.combustible_nombre = combustible_nombre;
		this.combustible_precio = combustible_precio;
	}

	// constructor vacío
	public Combustible() {
		super();
	}

	
	/******************************************* GETTER Y SETTERS *********************************************/
	public long getCombustible_id() {
		return combustible_id;
	}

	public void setCombustible_id(long combustible_id) {
		this.combustible_id = combustible_id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	/******************************************* MÉTODOS *********************************************/

	
	/******************************************* HashCode y Equals *********************************************/
	@Override
	public int hashCode() {
		return Objects.hash(combustible_id, combustible_nombre, combustible_precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combustible other = (Combustible) obj;
		return combustible_id == other.combustible_id && Objects.equals(combustible_nombre, other.combustible_nombre)
				&& Double.doubleToLongBits(combustible_precio) == Double.doubleToLongBits(other.combustible_precio);
	}

	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "\nCombustible [" + 
					"combustible_id=" + combustible_id + 
					", combustible_nombre=" + combustible_nombre + 
					", combustible_precio=" + combustible_precio + 
				"]";
	}
	
}