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
@Table(name = "dwh_gg_repostaje_vehiculo", schema = "dwh_gestion_gasolinera")
public class RepostajeVehiculo implements Serializable {

	private static final long serialVersionUID = 1L;


	/******************************************* ATRIBUTOS *********************************************/
	@Column(name = "repostajeVehiculo_uuid", unique = false, nullable = false)
	private String repostajeVehiculo_uuid;
	
	@Id
	@Column(name = "repostajeVehiculo_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long repostajeVehiculo_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "repostajeVehiculo_date", unique = false, nullable = false)
	private Date repostajeVehiculo_date;
	
	@Column(name = "repostajeVehiculo_dni", unique = false, nullable = false)
	private String repostajeVehiculo_dni;
	
	@Column(name = "repostajeVehiculo_matricula", unique = false, nullable = false)
	private String repostajeVehiculo_matricula;
	
	@Column(name = "repostajeVehiculo_litros", unique = false, nullable = false)
	private double repostajeVehiculo_litros;

/*	// si ya tengo un campo relacional que especifica un combustible, pues ya no me haría falta este campo aquí
	@Column(name = "repostajeVehiculo_combustible", unique = false, nullable = false, length = 11) // con una longitud de 11 se podría llegar a escribir como máximo Gasolina 95 o Gasolina 98
	private String repostajeVehiculo_combustible;
*/
	@Column(name = "repostajeVehiculo_importeTotal", unique = false, nullable = false)
	private double repostajeVehiculo_importeTotal;
	
	/******************************************* RELACIONES *********************************************/
	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Combustible combustible;
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno, sin el id, ni el uuid, ni la fecha-hora, porque son automáticos 
	// el uuid lo relleno en el dto con un método de la clase Tools 
	// y sin el importe total, ya que éste se calcula con un método (litros * combustible.precio)
	// este constructor sería para la factura
	public RepostajeVehiculo(String repostajeVehiculo_dni, String repostajeVehiculo_matricula, double repostajeVehiculo_litros, Combustible combustible
	) {
		super();
		this.repostajeVehiculo_dni = repostajeVehiculo_dni;
		this.repostajeVehiculo_matricula = repostajeVehiculo_matricula;
		this.repostajeVehiculo_litros = repostajeVehiculo_litros;
		this.combustible = combustible;
		this.repostajeVehiculo_importeTotal = calcularImporteTotal();
	}
	
	// este constructor sería para los tickets
	public RepostajeVehiculo(double repostajeVehiculo_litros, Combustible combustible) {
		super();
		this.repostajeVehiculo_litros = repostajeVehiculo_litros;
		this.combustible = combustible;
		this.repostajeVehiculo_importeTotal = calcularImporteTotal();
	}

	// constructor vacío
	public RepostajeVehiculo() {
		super();
	}


	/******************************************* GETTER Y SETTERS *********************************************/
	public String getRepostajeVehiculo_uuid() {
		return repostajeVehiculo_uuid;
	}

	public void setRepostajeVehiculo_uuid(String repostajeVehiculo_uuid) {
		this.repostajeVehiculo_uuid = repostajeVehiculo_uuid;
	}
	
	public long getRepostajeVehiculo_id() {
		return repostajeVehiculo_id;
	}

	public void setRepostajeVehiculo_id(long repostajeVehiculo_id) {
		this.repostajeVehiculo_id = repostajeVehiculo_id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		
	/******************************************* MÉTODOS *********************************************/
	public double calcularImporteTotal() {
		return this.getRepostajeVehiculo_litros() * this.combustible.getCombustible_precio();
	}
	
	
	/******************************************* HashCode y Equals *********************************************/
	@Override
	public int hashCode() {
		return Objects.hash(combustible, repostajeVehiculo_date, repostajeVehiculo_dni, repostajeVehiculo_id,
				repostajeVehiculo_importeTotal, repostajeVehiculo_litros, repostajeVehiculo_matricula,
				repostajeVehiculo_uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepostajeVehiculo other = (RepostajeVehiculo) obj;
		return Objects.equals(combustible, other.combustible)
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
		return "\nRepostajeVehiculo [" +
					", repostajeVehiculo_uuid=" + repostajeVehiculo_uuid + 
					"repostajeVehiculo_id=" + repostajeVehiculo_id + 
					", repostajeVehiculo_date=" + repostajeVehiculo_date + 
					", repostajeVehiculo_dni=" + repostajeVehiculo_dni + 
					", repostajeVehiculo_matricula=" + repostajeVehiculo_matricula + 
					", repostajeVehiculo_litros=" + repostajeVehiculo_litros + 
					", combustible=" + combustible +
					", repostajeVehiculo_importeTotal=" + repostajeVehiculo_importeTotal + 
				"]";
	}

}