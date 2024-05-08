package org.naw.productmanager.service.repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DataAccessManager {
	private static EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT = "productmanager";

	public static synchronized EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		return entityManagerFactory;
	}

	public static synchronized EntityManagerFactory setEnityManagerFactoryNull() {
		entityManagerFactory = null;
		return entityManagerFactory;

	}

}
