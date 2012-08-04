package br.com.zaul.util.dao.impl.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.zaul.util.dao.generic.GenericDao;

/**
 * 
 * @author thiago
 *
 * @param <T>
 * @param <PK>
 */
public abstract class JpaDAOImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	/** */
	protected abstract EntityManager getEntityManager();
	/** */
	private Class<T> entityClass;
	
	/**
	 * 
	 * @param entityClass
	 */
	public JpaDAOImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	/**
	 * 
	 */
	@Override
	public T create(T object) {
		this.getEntityManager().persist(object);
		return object;
	}

	/**
	 * 
	 */
	@Override
	public void update(T object) {
		this.getEntityManager().merge(object);
	}

	/**
	 * 
	 */
	@Override
	public void delete(T object) {
		this.getEntityManager().remove(object);
	}

	/**
	 * 
	 */
	@Override
	public T findByPK(PK id) {
		return this.getEntityManager().find(this.entityClass, id);
	}

	/**
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		StringBuilder jpql = new StringBuilder("FROM " + entityClass.getName());
		Query query = this.getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}

}
