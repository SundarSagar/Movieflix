package com.ragas.api.entity;


import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"), 
	@NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name=:pName")
})
public class Country {
	
	@Id
	private String id;
	
	@Column(unique=true)
	private String name;
	
	@ManyToMany(mappedBy = "countrys")
	 private List<Movie> movies;
	
	public Country() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Country(String name){
		this();
		this.setName(name);
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
    public List<Movie> getMovies() {
        return movies;
    }
	
	public void setMovies(List<Movie> movies){
		this.movies = movies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
