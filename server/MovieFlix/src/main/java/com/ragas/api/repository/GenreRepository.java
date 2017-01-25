package com.ragas.api.repository;

import java.util.List;

import com.ragas.api.entity.Genre;

public interface GenreRepository {

	public List<Genre> findAll();

	public Genre findOne(String id);
	
	public Genre findByGenreName(String genreName);

	public Genre create(Genre gen);

	public Genre update(Genre gen);

	public void delete(Genre gen);
}
