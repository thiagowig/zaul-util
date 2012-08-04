package br.com.zaul.util.dao.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 
 * @author thiago
 *
 */
public class HibernateUtil {

	/** */
	private static final String RESOURCE_FILE = "/resource/hibernate.cfg.xml";
	/** */
	private static final SessionFactory SESSION_FACTORY;
	/** */
	private static final ServiceRegistry SERVICE_REGISTRY;

	private static final Session SESSION;

	/**
	 * 
	 */
	static {
		Configuration configuration = new Configuration().configure(HibernateUtil.RESOURCE_FILE);

		SERVICE_REGISTRY = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

		SESSION_FACTORY = configuration.buildSessionFactory(SERVICE_REGISTRY);

		SESSION = SESSION_FACTORY.openSession();
	}

	/**
	 * 
	 * @return
	 */
	public static Session getSession() {
		return HibernateUtil.SESSION;
	}
}