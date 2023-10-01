package fadyfadd.sakilahibernate;

import org.hibernate.Session;

import fadyfadd.sakilahibernate.entities.Film;

public class GetFilmById {
	
	public static void main(String[] args) {
		
		try {
			Session session = new DataHelper().getSakilaSession();		
			session.beginTransaction();
			Film aFilm = session.get(Film.class, 1);
			System.out.println(aFilm);				
		}
		finally {
			new DataHelper().closeSession();
			new DataHelper().closeSessionFactory();				
		}

	}

}
