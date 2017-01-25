package com.ragas.api.service;

import java.util.List;

import com.ragas.api.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String title);

	public Movie create(Movie m);

	public Movie update(String id, Movie m);

	public void delete(String id);
}
