package com.GestionGasolinera.queries;

import java.util.List;

import com.GestionGasolinera.entities.Combustible;


public interface ICombustibleQuery {
	

	/**
	 * Listar combustibles.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Combustible> listarCombustibles() throws Exception;
	
	
	
	/**
	 * Buscar combustible por id.
	 *
	 * @param combustible_id the combustible id
	 * @return the combustible
	 * @throws Exception the exception
	 */
	public Combustible buscarCombustiblePorId(long combustible_id) throws Exception;
	
	
	
	/**
	 * Insertar combustible.
	 *
	 * @param combustible the combustible
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean insertarCombustible(Combustible combustible) throws Exception;
	
	
	
	/**
	 * Editar combustible.
	 *
	 * @param combustible_id the combustible id
	 * @param combustible_nombre the combustible nombre
	 * @param combustible_precio the combustible precio
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean editarCombustible(long combustible_id, String combustible_nombre, double combustible_precio) throws Exception;
	
	
	
	/**
	 * Eliminar combustible por id.
	 *
	 * @param combustible_id the combustible id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean eliminarCombustiblePorId(long combustible_id) throws Exception;
	
	
	
	
	/**
	 * Eliminar combustible.
	 *
	 * @param combustible the combustible
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean eliminarCombustible(Combustible combustible) throws Exception;
	
}
