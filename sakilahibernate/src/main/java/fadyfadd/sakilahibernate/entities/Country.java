package fadyfadd.sakilahibernate.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_id")
	private Integer countryId;
	
	public List<City> getCities() {
		return cities;
	}
	
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	@Column(name="country")
	private String country;
	
	@OneToMany(cascade=CascadeType.ALL , mappedBy="country")
	private List<City> cities = null; 
	
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	  
}
