package com.ragas.api.entity;

import java.util.UUID;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
	@NamedQuery(name = "Comments.findByMovieId", query = "SELECT c FROM Comments c WHERE c.movieId=:pmovieId") 
})
public class Comment {

	@Id
	private String id;
	
	private String movieId;
	
	private String userId;
	
	private String comment;
	

	public Comment() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}