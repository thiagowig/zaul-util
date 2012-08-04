package br.com.zaul.util.dao.impl.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import br.com.zaul.util.dao.generic.GenericDao;

/**
 * 
 * @author thiago
 *
 * @param <T>
 * @param <PK>
 */
public abstract class HibernateDAOImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	/** */
	private Session session = HibernateUtil.getSession();
	/** */
	private Class<T> classType;

	/**
	 * 
	 * @param classType
	 */
	public HibernateDAOImpl(Class<T> classType) {
		this.classType = classType;
	}

	/**
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public PK create(T object) {            
		this.BeginTransaction();

		PK pk = (PK) this.session.save(object);

		this.CommitTransaction();

		return pk;
	}

	/**
	 * 
	 */
	@Override
	public void update(T object) {
		this.BeginTransaction();

		this.session.update(object);

		this.CommitTransaction();
	}

	/**
	 * 
	 */
	@Override
	public void delete(T object) {
		this.BeginTransaction();

		this.session.delete(object);

		this.CommitTransaction();
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findByPK(PK id) {
		return (T) this.session.get(this.classType, id);
	}

	/**
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query query = this.session.createQuery("FROM " + this.classType.getName());

		return query.list();
	}

	/**
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T object) {
		Criteria criteria = this.session.createCriteria(this.classType);
		criteria.add(Example.create(object));

		return criteria.list();
	}

	/**
	 * 
	 */
	private void BeginTransaction() {
		this.getSession().beginTransaction();
	}

	/**
	 * 
	 */
	private void CommitTransaction() {
		this.getSession().getTransaction().commit();
	}

	/**
	 * 
	 * @return
	 */
	protected Session getSession() {
		return this.session;
	}

}
