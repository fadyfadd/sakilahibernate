package fadyfadd.sakilahibernate;

import org.hibernate.Session;

import fadyfadd.sakilahibernate.entities.*;

public class GetCountryById {
	
	public static void main(String[] args) {
		
		try {
			Session session = new DataHelper().getSakilaSession();		
			session.beginTransaction();
			Country aCountry = session.get(Country.class, 1);
			System.out.println(aCountry);			
		}
		finally {
			new DataHelper().closeSession();
			new DataHelper().closeSessionFactory();				
			
		}
	
	}

}