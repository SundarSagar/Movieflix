package com.ragas.api.service;

import java.util.List;

import com.ragas.api.entity.Genre;

public interface GenreService {

	public List<Genre> findAll();

	public Genre findOne(String id);

	public Genre create(Genre gen);

	public Genre update(String id, Genre gen);

	public void delete(String id);
}
