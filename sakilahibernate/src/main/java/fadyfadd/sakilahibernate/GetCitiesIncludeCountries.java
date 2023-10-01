package fadyfadd.sakilahibernate;

import java.util.List;

import org.hibernate.Session;

import fadyfadd.sakilahibernate.entities.*;

public class GetCitiesIncludeCountries {

	public static void main(String[] args) {

		try {
			Session session = new DataHelper().getSakilaSession();
			session.beginTransaction();

			List<?> rows = session.createQuery("select cn , ct from Country cn inner join City ct on ct.country = cn")
					.getResultList();

			for (Object row : rows) {

				Object[] data = (Object[]) row;
				Country country = (Country) data[0];
				City city = (City) data[1];
				System.out.println(country.getCountry() + "->" + city.getCity());

			}
		} finally {
			
			new DataHelper().closeSession();
			new DataHelper().closeSessionFactory();

		}

	}

}