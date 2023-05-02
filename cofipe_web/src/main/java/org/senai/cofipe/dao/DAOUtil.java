package org.senai.cofipe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOUtil {
	private static final String PU = "cofipePU";
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	/** Cria estaticamente a fábrica de EntityManager a partir da PU. */
	private static void createEntityManagerFactory() {
		try {
			emf = Persistence.createEntityManagerFactory(PU);
		} catch (Exception e) {
			throw new CreateEntityManagerFactoryException(PU);
		}
	}

	/**
	 * Método usado por alguns outros métodos desta classe para
	 * garantir que exista um gerenciador de entidades disponível.
	 * Este método primeiro verifica se uma fábrica está disponível.
	 * Caso não esteja, há a tentativa de criá-la. Caso consiga criar uma,
	 * verifica se realmente não há uma instância do gerenciador de entidades
	 * disponível. Se realmente uma não estiver disponível, ele criará uma.
	 */
	protected EntityManager getEM() {
		if(emf == null || !emf.isOpen()) {
			createEntityManagerFactory();
		}
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}
		return em;
	}
	
	protected void closeAndCommit() {
		this.getEM().getTransaction().commit();
		this.getEM().close();
		emf.close();
	}
}
