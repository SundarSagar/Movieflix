package com.ragas.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g"),
	@NamedQuery(name = "Genre.findByGenreName", query = "SELECT g FROM Genre g WHERE g.genreName=:pGenreName")
})
public class Genre {
	
	@Id
	private String id;
	
	@Column(unique=true)
	private String genreName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Genre(){
		this.id = UUID.randomUUID().toString();
	}
	
	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

}
