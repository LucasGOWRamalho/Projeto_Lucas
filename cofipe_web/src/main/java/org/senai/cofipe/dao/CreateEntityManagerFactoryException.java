package org.senai.cofipe.dao;

public class CreateEntityManagerFactoryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CreateEntityManagerFactoryException() {
		super();
	}

	public CreateEntityManagerFactoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CreateEntityManagerFactoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateEntityManagerFactoryException(String persistenceUnitName) {
		super("Falha na tentativa de criar uma fábrica para o gerenciador de entidades. "
				+ "Verifique as configurações da unidade de persistência " + persistenceUnitName +
				" no seu arquivo persistence.xml, ou verifique se o nome da unidade de persistência existe.");
	}

	public CreateEntityManagerFactoryException(Throwable cause) {
		super(cause);
	}
}