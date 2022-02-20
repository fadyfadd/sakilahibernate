package fadyfadd.sakilahibernate;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import fadyfadd.sakilahibernate.entities.Film;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
	@Before
	public void initializer() {
		
		
	}
	
	 
    @Test
    public void getFilmById()
    {
        SessionFactory factory = null; 
    	Session session = null; 
    	
    	try {
    			factory = new Configuration()
    				.configure("hibernate.cfg.xml")
    				.addAnnotatedClass(Film.class)
    				.buildSessionFactory();
    			
    			session = factory.getCurrentSession();
    			session.beginTransaction();
    			Film aFilm = session.get(Film.class, 1);
    			System.out.println(aFilm);	
    			session.getTransaction().commit();
    			assertTrue(aFilm != null);
  	
    	}
    	catch (Throwable ex)
    	{
    		throw ex; 
    		
    	}
    	
    	finally {
    		if (session != null)
    			session.close();
    		
    		if (factory != null)
    			factory.close();
    	}
    }
}
