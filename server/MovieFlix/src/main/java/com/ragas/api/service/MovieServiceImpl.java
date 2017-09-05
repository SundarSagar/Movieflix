package com.ragas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragas.api.entity.Movie;
import com.ragas.api.exception.BadRequestException;
import com.ragas.api.exception.EntityNotFoundException;
import com.ragas.api.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Movie findOne(String id) {
		
		Movie M = repository.findOne(id);
		if (M == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return M;
	}

	@Override
	@Transactional
	public Movie create(Movie m) {
		Movie existing = repository.findByTitle(m.getTitle());
		if (existing != null) {
			throw new BadRequestException("Movie with this title already exists");
		}
		return repository.create(m);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie m) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(m);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.delete(existing);
	
	}

}
