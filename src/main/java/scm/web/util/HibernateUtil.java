package scm.web.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class HibernateUtil {
 
//   private static SessionFactory sessionFactory;
//	
//	public static SessionFactory getSessionFactoryold() {
//		try{
//			if (sessionFactory == null) {
//				// loads configuration and mappings
//				Configuration configuration = new Configuration().configure();
//				ServiceRegistry serviceRegistry
//					= new StandardServiceRegistryBuilder()
//						.applySettings(configuration.getProperties()).build();
//				
//				// builds a session factory from the service registry
//				sessionFactory = configuration.buildSessionFactory(serviceRegistry);			
//			}
//		}
//		catch (Throwable ex) {
//			 
//			 // Make sure you log the exception, as it might be swallowed
//			 	System.err.println("SessionFactory creation failed." + ex);
//			 	throw new ExceptionInInitializerError(ex);
//			 
//			}
//		
//		return sessionFactory;
//	}
//	
//	public static SessionFactory getSessionFactory5() {
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//				.configure() // configures settings from hibernate.cfg.xml
//				.build();
//		try {
//			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//		}
//		catch (Exception e) {
//			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//			// so destroy it manually.
//			StandardServiceRegistryBuilder.destroy( registry );
//		}
//		
//		return sessionFactory;
//	}
	
   private static SessionFactory sessionFactory;
   private static ServiceRegistry serviceRegistry;

   static
   {
       try
       {
//         Configuration configuration = new Configuration();
           Configuration configuration = new Configuration().configure();

           serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       }
       catch (HibernateException he)
       {
           System.err.println("Error creating Session: " + he);
           throw new ExceptionInInitializerError(he);
       }
   }

   public static SessionFactory getSessionFactory()
   {
       return sessionFactory;
   } 
}