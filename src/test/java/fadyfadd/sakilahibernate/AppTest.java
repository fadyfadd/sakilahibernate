package fadyfadd.sakilahibernate;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import fadyfadd.sakilahibernate.entities.Actor;
import fadyfadd.sakilahibernate.entities.Film;


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
    				.addAnnotatedClass(Actor.class)    				
    				.buildSessionFactory();
    			
    			session = factory.getCurrentSession();
    			session.beginTransaction();
    			Film aFilm = session.get(Film.class, 1);
    			System.out.println(aFilm);	
    			assertTrue(aFilm != null);
    			assertTrue(aFilm != null && aFilm.getActors().size() > 0);
    			session.getTransaction().commit();
    			
  	
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
    
    @Test
    public void getActorById() {

        SessionFactory factory = null; 
    	Session session = null; 
    	
    	try {
    			factory = new Configuration()
    				.configure("hibernate.cfg.xml")
    				.addAnnotatedClass(Actor.class)
    				.addAnnotatedClass(Film.class)
    				.buildSessionFactory();
    			
    			session = factory.getCurrentSession();
    			session.beginTransaction();
    			Actor anActor = session.get(Actor.class, 1);
    			System.out.println(anActor);	
    		
    			assertTrue(anActor != null);
    			assertTrue(anActor != null && anActor.getFilms().size() > 0);
    			session.getTransaction().commit();
  	
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
