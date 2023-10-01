package fadyfadd.sakilahibernate;

import org.hibernate.Session;

import fadyfadd.sakilahibernate.entities.*;

public class GetCityById {
	
	public static void main(String[] args) {
		
		try {			
			Session session = new DataHelper().getSakilaSession();		
			session.beginTransaction();
		    City aCity = session.get(City.class, 1);
			System.out.println(aCity);			
			
		}
		finally {
			new DataHelper().closeSession();
			new DataHelper().closeSessionFactory();				
		}

	}

}