package com.ragas.api.entity;


import java.util.List;
//import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({ 
	@NamedQuery(name = "Writer.findAll", query = "SELECT w FROM Writer w"), 
	@NamedQuery(name = "Writer.findByName", query = "SELECT w FROM Writer w WHERE w.name=:pName")
})
public class Writer {
	
	@Id
	private String id;
	
	@Column(unique=true)
	private String name;
	
	@ManyToMany(mappedBy = "writers")
	 private List<Movie> movies;
	
	public Writer() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Writer(String name){
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
