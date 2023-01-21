package com.GestionGasolinera.repositories;

import java.util.List;

import com.GestionGasolinera.entities.Combustible;


public interface ICombustibleRepository {


	/**
	 * List combustibles.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Combustible> listCombustibles() throws Exception;
	
	

	/**
	 * Find by id combustible.
	 *
	 * @param combustible_id the combustible id
	 * @return the combustible
	 * @throws Exception the exception
	 */
	public Combustible findByIdCombustible(long combustible_id) throws Exception;
	
	

	/**
	 * Insert combustible.
	 *
	 * @param combustible the combustible
	 * @throws Exception the exception
	 */
	public void insertCombustible(Combustible combustible) throws Exception;
	
	

	/**
	 * Edits the combustible.
	 *
	 * @param combustible_id the combustible id
	 * @param combustible_nombre the combustible nombre
	 * @param combustible_precio the combustible precio
	 * @throws Exception the exception
	 */
	public void editCombustible(long combustible_id, String combustible_nombre, double combustible_precio) throws Exception;
	
	

	/**
	 * Delete by id combustible.
	 *
	 * @param combustible_id the combustible id
	 * @throws Exception the exception
	 */
	public void deleteByIdCombustible(long combustible_id) throws Exception;
	
	
	
	/**
	 * Delete combustible.
	 *
	 * @param combustible the combustible
	 * @throws Exception the exception
	 */
	public void deleteCombustible(Combustible combustible) throws Exception;

}