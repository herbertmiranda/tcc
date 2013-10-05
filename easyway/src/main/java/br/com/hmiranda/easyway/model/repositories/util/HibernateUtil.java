package br.com.hmiranda.easyway.model.repositories.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManager entityManager;

	private static EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("springJpaPU");
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null)
			entityManager = getEntityManagerFactory().createEntityManager();
		return entityManager;
	}

	public static void save(Object entidade) {
		getEntityManager().getTransaction().begin();
		try {
			getEntityManager().persist(entidade);
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}

	public static void update(Object entidade) {
		getEntityManager().getTransaction().begin();
		try {
			getEntityManager().merge(entidade);
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}

	}

	public static void delete(Object entidade) {
		getEntityManager().getTransaction().begin();
		try {
			getEntityManager().remove(entidade);
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
	}

}
