package helpers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryHelper {
	
	public static SessionFactory factory;
	
	public static SessionFactory GetFactory() {
		if(factory==null) {
			try {
				factory = new Configuration().configure("configuration.cfg.xml").buildSessionFactory();
//                Configuration config = new Configuration();
//                config.configure("configuration.cfg.xml");
//                SessionFactory factory = config.buildSessionFactory();
                
			} catch (Throwable ex) {
                System.err.println("Failed to create SessionFactory: " + ex);
                throw new ExceptionInInitializerError(ex);
            }
		}
		return factory;
	}
	
	public static void CloseFactory() {
		if(factory.isOpen()) {
			factory.close();
		}
	}

}
