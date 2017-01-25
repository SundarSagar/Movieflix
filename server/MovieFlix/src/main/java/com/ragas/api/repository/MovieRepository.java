package com.ragas.api.repository;

import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;

import com.ragas.api.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findOne(String title);
	
	public Movie findByTitle(String title);
	
	public Movie create(Movie m);

	public Movie update(Movie m);

	public void delete(Movie m);
}
