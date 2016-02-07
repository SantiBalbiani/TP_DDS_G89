package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateConf {
 
	private static final SessionFactory sessionFactory = buildSessionFactory();
 
	private static SessionFactory buildSessionFactory() {
		try {
			// Creo SessionFactory tomando el archivo hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Aca habría que loguear el error, porque podría tragarla
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void shutdown() {
		//Vacìo la cache y cierro las conexiones
		getSessionFactory().close();
	}
 
}
