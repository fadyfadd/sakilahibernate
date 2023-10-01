package fadyfadd.sakilahibernate;

import org.hibernate.Session;

import fadyfadd.sakilahibernate.entities.*;

public class GetActorById {
	
	public static void main(String[] args) {
		
		try {
			Session session = new DataHelper().getSakilaSession();		
			session.beginTransaction();
			Actor aActor = session.get(Actor.class, 1);
			System.out.println(aActor);	
		}		
		finally {
			new DataHelper().closeSession();
			new DataHelper().closeSessionFactory();
			 
		}
		
		
	}

}