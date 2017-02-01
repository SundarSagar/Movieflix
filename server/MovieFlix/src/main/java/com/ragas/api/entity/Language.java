package com.ragas.api.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
	@NamedQuery(name = "Language.findByName", query = "SELECT l FROM Language l WHERE l.name=:pName") 
})
public class Language {
	@Id
	private String id;
	
	@Column(unique=true)
	private String name;
	
	@ManyToMany(mappedBy = "languages")
	private List<Movie> movies;
	
	public Language() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    public List<Movie> getMovies() {
        return movies;
    }
	
	public void setMovies(List<Movie> movies){
		this.movies = movies;
	}
}
