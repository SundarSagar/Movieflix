package com.ragas.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
	@NamedQuery(name = "Language.findByName", query = "SELECT l FROM Language l WHERE l.Name=:pName") 
})
public class Language {
	@Id
	private String id;
	
	@Column(unique=true)
	private String name;
	
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
}
