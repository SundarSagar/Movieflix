package com.ragas.api.entity;


import java.util.List;
//import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
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
	@NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name=:pCountryName")
})
public class Country {
	
	@Id
	@Column(name = "Country_id")
	private String id;
	
	@Column(unique=true)
	private String countryName;
	
	@ManyToMany(mappedBy = "countrys",cascade = CascadeType.PERSIST)
	 private List<Movie> movies;
	
	public Country() {
		this.id = UUID.randomUUID().toString();
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

	public String getcountryName() {
		return countryName;
	}

	public void setcountryName(String countryName) {
		this.countryName = countryName;
	}

}
