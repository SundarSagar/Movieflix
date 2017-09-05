package com.ragas.api.entity;


import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:pTitle") 
})
public class Movie {

	@Id
	private String id;
	
	@Column(unique=true)
	private String title;
	
	private int year;
	
	private String rated;
	
	private String released;
	
	private String runTime;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	      name="Movie_Genre",
	      joinColumns=@JoinColumn(name="Movie_Id", referencedColumnName="id"),
	      inverseJoinColumns=@JoinColumn(name="Genre_Id", referencedColumnName="id"))
	private List<Genre> genres;
	
	private String director;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	      name="Movie_Writer",
	      joinColumns=@JoinColumn(name="id", referencedColumnName="id"),
	      inverseJoinColumns=@JoinColumn(name="Writer_Id", referencedColumnName="id"))
	private List<Writer> writers;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	      name="Movie_Actors",
	      joinColumns=@JoinColumn(name="id", referencedColumnName="id"),
	      inverseJoinColumns=@JoinColumn(name="Actor_Id", referencedColumnName="id"))
	private List<Actor> actors;
	
	private String plot;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	      name="Movie_Language",
	      joinColumns=@JoinColumn(name="id", referencedColumnName="id"),
	      inverseJoinColumns=@JoinColumn(name="Language_Id", referencedColumnName="id"))
	private List<Language> languages;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	      name="Movie_Country",
	      joinColumns=@JoinColumn(name="id", referencedColumnName="id"),
	      inverseJoinColumns=@JoinColumn(name="Country_Id", referencedColumnName="id"))
	private List<Country> countrys;
	
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
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

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<Writer> getWriters() {
		return writers;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}

	public List<Country> getCountrys() {
		return countrys;
	}

	public void setCountrys(List<Country> countrys) {
		this.countrys = countrys;
	}

}