package com.GestionGasolinera.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.GestionGasolinera.entities.Combustible;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Repository("CombustibleRepositoryImpl")
public class CombustibleRepositoryImpl implements ICombustibleRepository{

	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	

	/**
	 * List combustibles.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Override
	public List<Combustible> listCombustibles()  throws Exception {
		
		// the lowercase c refers to the object
    	// :objectID is a parameterized query thats value is set below
    	String query = "SELECT c FROM Combustible c WHERE c.id IS NOT NULL";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Combustible> typedQuery = entityManager.createQuery(query, Combustible.class);
    	List<Combustible> listaCombustibles = new ArrayList<>();
    	try {
    		// Get matching objects and output
    		listaCombustibles = typedQuery.getResultList();
    	}
    	
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	
    	finally {
    		// Close EntityManager
    		entityManager.clear();
    		entityManager.close();
    	}
    	
    	return listaCombustibles;
	}

	

	/**
	 * Find by id combustible.
	 *
	 * @param combustible_id the combustible id
	 * @return the combustible
	 * @throws Exception the exception
	 */
	@Override
	public Combustible findByIdCombustible(long combustible_id) throws Exception {

		// the lowercase a refers to the object
    	// :objectID is a parameterized query thats value is set below
    	String query = "SELECT c FROM combustible c WHERE c.id = :combustibleID";
    	
    	// Issue the query and get a matching Customer
    	TypedQuery<Combustible> typedQuery = entityManager.createQuery(query, Combustible.class);
    	typedQuery.setParameter("combustibleID", combustible_id);
    	
    	Combustible combustible = new Combustible();
    	
    	try {
    		// Get matching student object and output
    		combustible = typedQuery.getSingleResult();
    		
    	}
    	catch(NoResultException e) {
    		e.printStackTrace();
    	}
    	
    	finally {
    		// Close EntityManager
    		entityManager.clear();
    		entityManager.close();
    	}
    	
    	return combustible;
	}


	
	/**
	 * Insert combustible.
	 *
	 * @param combustible the combustible
	 * @throws Exception the exception
	 */
	@Override
	public void insertCombustible(Combustible combustible) throws Exception {
		EntityTransaction entityTransaction = null;
		 
        try {
            // Get transaction and start
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
 
            // Save the object
            entityManager.persist(combustible);
            entityTransaction.commit();
            
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            
            ex.printStackTrace();
        
        } finally {
            // Close EntityManager
        	entityManager.clear();
            entityManager.close();
        }
	}
	
	

	/**
	 * Edits the combustible.
	 *
	 * @param combustible_id the combustible id
	 * @param combustible_nombre the combustible nombre
	 * @param combustible_precio the combustible precio
	 * @throws Exception the exception
	 */
	@Override
	public void editCombustible(long combustible_id ,String combustible_nombre, double combustible_precio) throws Exception {
		EntityTransaction entityTransaction = null;
		Combustible combustible = new Combustible();
		
		try {
            // Get transaction and start
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
 
            // Find object and make changes
            combustible = entityManager.find(Combustible.class, combustible_id);
            combustible.setCombustible_nombre(combustible_nombre);
            combustible.setCombustible_precio(combustible_precio);
 
            // Save the object
            entityManager.persist(combustible);
            entityTransaction.commit();
            
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            
            ex.printStackTrace();
        
        } finally {
            // Close EntityManager
        	entityManager.clear();
            entityManager.close();
        }
	}

	
	
	/**
	 * Delete by id combustible.
	 *
	 * @param combustible_id the combustible id
	 * @throws Exception the exception
	 */
	@Override
	public void deleteByIdCombustible(long combustible_id) throws Exception {
		EntityTransaction entityTransaction = null;
		Combustible combustible = new Combustible();
 
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            combustible = entityManager.find(Combustible.class, combustible_id);
            entityManager.remove(combustible);
            entityTransaction.commit();
        
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            
            ex.printStackTrace();
        
        } finally {
            // Close EntityManager
        	entityManager.clear();
            entityManager.close();
        }
	}



	/**
	 * Delete combustible.
	 *
	 * @param combustible the combustible
	 * @throws Exception the exception
	 */
	@Override
	public void deleteCombustible(Combustible combustible) throws Exception {
		EntityTransaction entityTransaction = null;
 
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            
            entityManager.remove(combustible);
            entityTransaction.commit();
        
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            
            ex.printStackTrace();
        
        } finally {
            // Close EntityManager
        	entityManager.clear();
            entityManager.close();
        }
	}

}