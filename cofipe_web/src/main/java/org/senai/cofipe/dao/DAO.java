package org.senai.cofipe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

/**
 * Classe DAO genérica.
 * Constrói o EntityManager a partir da PU (Persistence Unity) e executa o CRUD.
 * 
 * @author Rudimar Schmitz
 * @since 2023-04-07
 * @version 1.01
 *
 * @param <E> - representa a Entidade (E.class)
 */
public class DAO<E> {
	private Class<E> entityClass;
	private DAOUtil util = new DAOUtil();

	public DAO(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public void startTransaction() {
		util.getEM().getTransaction().begin();
	}

	public void closeAndCommit() {
		util.closeAndCommit();
	}
	
	public void persist(E entity) {
		startTransaction();
		util.getEM().persist(entity);
		closeAndCommit();
	}
	
	public E getById(Integer id) {
		startTransaction();
		E entity = util.getEM().find(entityClass, id);
		closeAndCommit();
		return entity;
	}
	
	public Boolean delete(Integer id) {
		startTransaction();
		E entity = util.getEM().find(entityClass, id);
		util.getEM().remove(entity);
		closeAndCommit();
		return true;
	}
	
	public E update(E entity) {
		startTransaction();
		util.getEM().merge(entity);
		closeAndCommit();
		return entity;
	}

	public List<E> getAll() {
		startTransaction();
		
		String className = entityClass.getSimpleName();
		String sql = "SELECT e FROM " + className + " e";
		TypedQuery<E> query = util.getEM().createQuery(sql, entityClass);
		
		List<E> lista = query.getResultList();
		closeAndCommit();
		
		return lista;
	}
	
	protected DAOUtil getDAOUtil() {
		return this.util;
	}
	
}
