package fadyfadd.sakilahibernate.entities;

import javax.persistence.*;


@Entity
@Table(name="film")
public class Film {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="film_id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="release_year")
	private Integer releaseYear;
	
	
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
