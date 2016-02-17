package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.service.ServiceRegistry;

public class HibernateConf {
	
	private static SessionFactory sessionFactory;
 
	public static SessionFactory getSessionFactory() {
		try {
	        if (sessionFactory == null) {
	            // loads configuration and mappings
	            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	            ServiceRegistry serviceRegistry
	                = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();

	            // builds a session factory from the service registry
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
	        }

	        return sessionFactory;
		} catch (Throwable ex) {
			// Aca habr�a que loguear el error, porque podr�a tragarla
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
 
	public static void shutdown() {
		//Vac�o la cache y cierro las conexiones
		getSessionFactory().close();
	}
 
}


//Santi... el codigo de aca abajo es uno que habia dejado de prueba pensando que el error podia estar
// en usar un metodo deprecated... la realidad es que despues volvi al codigo del ejemplo y nose si funciona..
// para no perderlo por el momento lo dejo aca abajo comentado....
//
/*
package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;  
 
public class HibernateConf {
 /*
	//private static final SessionFactory sessionFactory = buildSessionFactory();
	//private static SessionFactory sessionFactory;
	//private static ServiceRegistry serviceRegistry;
 
	private static SessionFactory buildSessionFactory() {
		try {
			// Creo SessionFactory tomando el archivo hibernate.cfg.xml
			//Configuration configuration = new Configuration();
		    //configuration.configure("hibernate.cfg.xml");
		    //serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		    //        configuration.getProperties()).build();
		    //sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			final Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		    final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		    final SessionFactory factory = configuration.buildSessionFactory(builder.build());


		    return factory;
		} catch (Throwable ex) {
			// Aca habr�a que loguear el error, porque podr�a tragarla
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		//return sessionFactory;
		return buildSessionFactory();
	}
 
	public static void shutdown() {
		//Vac�o la cache y cierro las conexiones
		getSessionFactory().close();
	}
 
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory createSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.configure().buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} catch (Throwable ex) {
			// Aca habr�a que loguear el error, porque podr�a tragarla
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return createSessionFactory();
	}
	
	public static void shutdown() {
		//Vac�o la cache y cierro las conexiones
		getSessionFactory().close();
	}
	
}
*/