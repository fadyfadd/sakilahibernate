package fadyfadd.sakilahibernate.entities;

import java.util.List;

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
	
	
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})

	@JoinTable(
			name="film_actor",
			joinColumns=@JoinColumn(name="film_id"),
			inverseJoinColumns=@JoinColumn(name="actor_id")
			)
	private List<Actor> actors;
	
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
