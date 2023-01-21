package com.GestionGasolinera.services;

import com.GestionGasolinera.entities.Combustible;
import com.GestionGasolinera.queries.ICombustibleQuery;


public interface ICombustibleService {
	
	
	
	/**
	 * Mostrar lista de combustibles.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	public void mostrarListaDeCombustibles(ICombustibleQuery combustibleQueryImpl) throws Exception;
	
	
	
	/**
	 * Mostrar un combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	public void mostrarUnCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception;
	

	
	/**
	 * Seleccionar un combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @return the combustible
	 * @throws Exception the exception
	 */
	public Combustible seleccionarUnCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception;
	
	
	
	/**
	 * Crear un nuevo combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	public void crearUnNuevoCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception;
	
	
	
	/**
	 * Editar nombre ø precio de un combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	public void editarNombreØPrecioDeUnCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception;
	
	
	
	/**
	 * Eliminar un combustible.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	public void eliminarUnCombustible(ICombustibleQuery combustibleQueryImpl) throws Exception;
	
	
	
	/**
	 * Eliminar un combustible por id.
	 *
	 * @param combustibleQueryImpl the combustible query impl
	 * @throws Exception the exception
	 */
	public void eliminarUnCombustiblePorId(ICombustibleQuery combustibleQueryImpl) throws Exception;
	
}
