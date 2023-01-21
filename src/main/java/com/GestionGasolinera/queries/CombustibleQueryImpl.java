package com.GestionGasolinera.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionGasolinera.entities.Combustible;
import com.GestionGasolinera.repositories.ICombustibleRepository;


@Service("CombustibleQueryImpl")
public class CombustibleQueryImpl implements ICombustibleQuery {

	/** The combustible repository impl. */
	@Autowired
	ICombustibleRepository combustibleRepositoryImpl;

	

	/**
	 * Listar combustibles.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public List<Combustible> listarCombustibles() throws Exception {
		try {
			return combustibleRepositoryImpl.listCombustibles();
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al listar los combustibles (return null): " + e);
			return null;
		}
	}

	

	/**
	 * Buscar combustible por id.
	 *
	 * @param combustible_id the combustible id
	 * @return the combustible
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public Combustible buscarCombustiblePorId(long combustible_id) throws Exception {
		try {
			return combustibleRepositoryImpl.findByIdCombustible(combustible_id);
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al buscar el combustible (return null): " + e);
			return null;
		}
	}

	

	/**
	 * Insertar combustible.
	 *
	 * @param combustible the combustible
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean insertarCombustible(Combustible combustible) throws Exception {
		try {
			combustibleRepositoryImpl.insertCombustible(combustible);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al insertar el nuevo combustible: " + e);
			return false;
		}
	}

	

	/**
	 * Editar combustible.
	 *
	 * @param combustible_id the combustible id
	 * @param combustible_nombre the combustible nombre
	 * @param combustible_precio the combustible precio
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean editarCombustible(long combustible_id, String combustible_nombre, double combustible_precio) throws Exception {
		try {
			combustibleRepositoryImpl.editCombustible(combustible_id, combustible_nombre, combustible_precio);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al editar el combustible seleccionado: " + e);
			return false;
		}
	}

	

	/**
	 * Eliminar combustible por id.
	 *
	 * @param combustible_id the combustible id
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean eliminarCombustiblePorId(long combustible_id) throws Exception {
		try {
			combustibleRepositoryImpl.deleteByIdCombustible(combustible_id);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al eliminar el combustible seleccionado: " + e);
			return false;
		}
	}

	

	/**
	 * Eliminar combustible.
	 *
	 * @param combustible the combustible
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean eliminarCombustible(Combustible combustible) throws Exception {
		try {
			combustibleRepositoryImpl.deleteCombustible(combustible);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al eliminar el combustible seleccionado: " + e);
			return false;
		}
	}
	
}
