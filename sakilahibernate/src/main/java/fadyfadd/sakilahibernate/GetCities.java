package fadyfadd.sakilahibernate;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import java.util.*;
import javax.persistence.ParameterMode;
import fadyfadd.sakilahibernate.entities.*;


@SuppressWarnings("unchecked")
public class GetCities {
	
	public static Map<Object, Object> GetCities(Integer cityId) {
		
		List<City> outputCities = new ArrayList<City>();		
		Session session = new DataHelper().getSakilaSession();	
		session.beginTransaction(); 
		ProcedureCall call = session.createStoredProcedureCall("get_cities_sp");
		call.registerParameter("cities", Integer.class,ParameterMode.OUT).enablePassingNulls(true);
		call.registerParameter("acity_id", Integer.class,ParameterMode.IN).enablePassingNulls(true);
		call.setParameter("acity_id", cityId);
		List<Object[]> cities = call.getResultList();	
		
		cities.stream().forEach((a)->{
			City city = new City(); 
			city.setCountry(new Country());
			city.getCountry().setCountry((String)a[0]); 
			city.setCityId((Integer)a[1]);
			city.setCity((String)a[2]); 
			city.getCountry().setCountryId((Integer)a[3]);
			outputCities.add(city);			
		});	 
		
		Map<Object, Object> attributesMap = new HashMap<Object,Object>(); 
		attributesMap.put("cities", outputCities); 
		attributesMap.put("count",call.getOutputParameterValue("cities"));		 
		session.close();
		return attributesMap; 
	}
	 
	public static void main(String[] args) {
		
		try {
			Map<Object, Object>  resultMap = GetCities(null);
			System.out.println(resultMap.get("cities"));
			System.out.println(resultMap.get("count"));			
		}
		finally {
			new DataHelper().closeSession();
			new DataHelper().closeSessionFactory();	
			
		}
		

		 
		 
	}

}