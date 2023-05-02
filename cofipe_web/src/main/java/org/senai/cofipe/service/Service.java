package org.senai.cofipe.service;

import java.util.List;

import org.senai.cofipe.dao.DAO;

public class Service<E> {
	private DAO<E> dao;
	
	public Service(Class<E> entityClass) {
		this.dao = new DAO<>(entityClass);
	}
	
	public E persist(E entity) {
		dao.persist(entity);
		return entity;
	}
	
	public E update(E entity) {
		return dao.update(entity);
	}
	
	public E getById(Integer id) {
		return dao.getById(id);
	}
	
	public List<E> getAll() {
		return dao.getAll();
	}
}
