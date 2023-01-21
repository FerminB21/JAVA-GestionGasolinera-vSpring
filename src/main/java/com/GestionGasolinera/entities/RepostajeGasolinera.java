package com.GestionGasolinera.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "dwh_gg_repostaje_gasolinera", schema = "dwh_gestion_gasolinera")
public class RepostajeGasolinera implements Serializable {

	private static final long serialVersionUID = 1L;


	/******************************************* ATRIBUTOS *********************************************/
	@Column(name = "repostajeGasolinera_uuid", unique = false, nullable = false)
	private String repostajeGasolinera_uuid;
	
	@Id
	@Column(name = "repostajeGasolinera_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long repostajeGasolinera_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "repostajeGasolinera_date", unique = false, nullable = false)
	private Date repostajeGasolinera_date;
	
	@Column(name = "repostajeGasolinera_dni", unique = false, nullable = false)
	private String repostajeGasolinera_dni;
	
	@Column(name = "repostajeGasolinera_matricula", unique = false, nullable = false)
	private String repostajeGasolinera_matricula;
	
	@Column(name = "repostajeGasolinera_litros", unique = false, nullable = false)
	private double repostajeGasolinera_litros;
/*
	@Column(name = "repostajeGasolinera_combustible", unique = false, nullable = false, length = 11) // con una longitud de 11 se podría llegar a escribir como máximo Gasolina 95 o Gasolina 98
	private String repostajeGasolinera_combustible;
*/
	@Column(name = "repostajeGasolinera_importeTotal", unique = false, nullable = false)
	private double repostajeGasolinera_importeTotal;

	
	/******************************************* RELACIONES *********************************************/
	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Combustible combustible;
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno, sin el id, ni el uuid, ni la fecha-hora, porque son automáticos 
	// el uuid lo relleno en el dto con un método de la clase Tools 
	// y sin el importe total, ya que éste se calcula con un método (litros * combustible.precio)
	// este constructor sería para la factura
	public RepostajeGasolinera(String repostajeGasolinera_dni, String repostajeGasolinera_matricula, double repostajeGasolinera_litros, Combustible combustible) {
		super();
		this.repostajeGasolinera_dni = repostajeGasolinera_dni;
		this.repostajeGasolinera_matricula = repostajeGasolinera_matricula;
		this.repostajeGasolinera_litros = repostajeGasolinera_litros;
		this.combustible = combustible;
		this.repostajeGasolinera_importeTotal = calcularImporteTotal();
	}
	
	// este constructor sería para los tickets
	public RepostajeGasolinera(double repostajeGasolinera_litros, Combustible combustible) {
		super();
		this.repostajeGasolinera_litros = repostajeGasolinera_litros;
		this.combustible = combustible;
		this.repostajeGasolinera_importeTotal = calcularImporteTotal();
	}

	// constructor vacío
	public RepostajeGasolinera() {
		super();
	}
	

	/******************************************* GETTER Y SETTERS *********************************************/
	public String getRepostajeGasolinera_uuid() {
		return repostajeGasolinera_uuid;
	}

	public void setRepostajeGasolinera_uuid(String repostajeGasolinera_uuid) {
		this.repostajeGasolinera_uuid = repostajeGasolinera_uuid;
	}
	
	public long getRepostajeGasolinera_id() {
		return repostajeGasolinera_id;
	}

	public void setRepostajeGasolinera_id(long repostajeGasolinera_id) {
		this.repostajeGasolinera_id = repostajeGasolinera_id;
	}

	public Date getRepostajeGasolinera_date() {
		return repostajeGasolinera_date;
	}

	public void setRepostajeGasolinera_date(Date repostajeGasolinera_date) {
		this.repostajeGasolinera_date = repostajeGasolinera_date;
	}

	public String getRepostajeGasolinera_dni() {
		return repostajeGasolinera_dni;
	}

	public void setRepostajeGasolinera_dni(String repostajeGasolinera_dni) {
		this.repostajeGasolinera_dni = repostajeGasolinera_dni;
	}

	public String getRepostajeGasolinera_matricula() {
		return repostajeGasolinera_matricula;
	}

	public void setRepostajeGasolinera_matricula(String repostajeGasolinera_matricula) {
		this.repostajeGasolinera_matricula = repostajeGasolinera_matricula;
	}

	public double getRepostajeGasolinera_litros() {
		return repostajeGasolinera_litros;
	}

	public void setRepostajeGasolinera_litros(double repostajeGasolinera_litros) {
		this.repostajeGasolinera_litros = repostajeGasolinera_litros;
	}

	public double getRepostajeGasolinera_importeTotal() {
		return repostajeGasolinera_importeTotal;
	}

	public void setRepostajeGasolinera_importeTotal(double repostajeGasolinera_importeTotal) {
		this.repostajeGasolinera_importeTotal = repostajeGasolinera_importeTotal;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	/******************************************* MÉTODOS *********************************************/
	public double calcularImporteTotal() {
		return this.getRepostajeGasolinera_litros() * this.combustible.getCombustible_precio();
	}
	
	
	/******************************************* HashCode y Equals *********************************************/
	@Override
	public int hashCode() {
		return Objects.hash(combustible, repostajeGasolinera_date, repostajeGasolinera_dni, repostajeGasolinera_id,
				repostajeGasolinera_importeTotal, repostajeGasolinera_litros, repostajeGasolinera_matricula,
				repostajeGasolinera_uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepostajeGasolinera other = (RepostajeGasolinera) obj;
		return Objects.equals(combustible, other.combustible)
				&& Objects.equals(repostajeGasolinera_date, other.repostajeGasolinera_date)
				&& Objects.equals(repostajeGasolinera_dni, other.repostajeGasolinera_dni)
				&& repostajeGasolinera_id == other.repostajeGasolinera_id
				&& Double.doubleToLongBits(repostajeGasolinera_importeTotal) == Double
						.doubleToLongBits(other.repostajeGasolinera_importeTotal)
				&& Double.doubleToLongBits(repostajeGasolinera_litros) == Double
						.doubleToLongBits(other.repostajeGasolinera_litros)
				&& Objects.equals(repostajeGasolinera_matricula, other.repostajeGasolinera_matricula)
				&& Objects.equals(repostajeGasolinera_uuid, other.repostajeGasolinera_uuid);
	}

	
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "\nRepostajeGasolinera [" + 
					", repostajeGasolinera_uuid=" + repostajeGasolinera_uuid +
					"repostajeGasolinera_id=" + repostajeGasolinera_id + 
					", repostajeGasolinera_date=" + repostajeGasolinera_date + 
					", repostajeGasolinera_dni=" + repostajeGasolinera_dni + 
					", repostajeGasolinera_matricula=" + repostajeGasolinera_matricula + 
					", repostajeGasolinera_litros=" + repostajeGasolinera_litros +
					", combustible=" + combustible + 
					", repostajeGasolinera_importeTotal=" + repostajeGasolinera_importeTotal +
				"]";
	}
	
}