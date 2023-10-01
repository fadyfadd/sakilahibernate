package fadyfadd.sakilahibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import fadyfadd.sakilahibernate.entities.Actor;
import fadyfadd.sakilahibernate.entities.City;
import fadyfadd.sakilahibernate.entities.Country;
import fadyfadd.sakilahibernate.entities.Film;

public class DataHelper {

	SessionFactory factory = null;
	Session session = null; 

	public Session getSakilaSession() {

		if (factory == null) {
			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Film.class)
					.addAnnotatedClass(Actor.class)  
					.addAnnotatedClass(Country.class)
					.addAnnotatedClass(City.class)
					.buildSessionFactory();

		}

		if (session == null) {
			session = factory.getCurrentSession();
		}
		 	
		return session;
	}
		
	public void closeSession() {
		
		if (session != null)
			session.close();
	}

	public void closeSessionFactory() {
		
		if (factory != null)
			factory.close();
	}

}
