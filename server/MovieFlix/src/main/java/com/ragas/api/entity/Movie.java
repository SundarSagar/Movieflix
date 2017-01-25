package com.ragas.api.entity;


import java.util.List;
//import java.util.Set;
import java.util.UUID;
import com.ragas.api.entity.Actor;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



import javax.persistence.ManyToMany;


@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m") 
})
public class Movie {

	@Id
	@Column(name = "Movie_id")
	private String id;
	
	@Column(unique=true)
	private String title;
	
	private int year;
	
	private String rated;
	
	private String released;
	
	private String runTime;
	
	private String genre;
	
	private String director;
	
	private String writer;
	

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Actor> actors;
	
	private String plot;
	
	private String language;
	
	private String country;
	
	private String awards;
	
	private String poster;
	
	private int metascore;
	
	private float imdbRating;
	
	private float imdbVotes;
	
	private String imdbId;
	
	private String type;

	public Movie() {	
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    @ManyToMany
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public float getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(float imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}