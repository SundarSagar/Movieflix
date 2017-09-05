package com.ragas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragas.api.entity.Genre;
import com.ragas.api.exception.BadRequestException;
import com.ragas.api.exception.EntityNotFoundException;
import com.ragas.api.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Genre> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Genre findOne(String id) {
		Genre gen = repository.findOne(id);
		if (gen == null) {
			throw new EntityNotFoundException("Genre not found");
		}
		return gen;
	}

	@Override
	@Transactional
	public Genre create(Genre gen) {
		Genre existing = repository.findByGenreName(gen.getGenreName());
		if (existing != null) {
			throw new BadRequestException("Genre with this email already exists");
		}
		return repository.create(gen);
	}

	@Override
	@Transactional
	public Genre update(String id, Genre gen) {
		Genre existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Genre not found");
		}
		return repository.update(gen);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Genre existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Genre not found");
		}
		repository.delete(existing);
	}
}