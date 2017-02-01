package com.ragas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragas.api.entity.Country;
import com.ragas.api.exception.BadRequestException;
import com.ragas.api.exception.EntityNotFoundException;
import com.ragas.api.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Country> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Country findOne(String id) {
		Country c = repository.findOne(id);
		if (c == null) {
			throw new EntityNotFoundException("Country not found");
		}
		return c;
	}

	@Override
	@Transactional
	public Country create(Country c) {
		Country existing = repository.findByName(c.getName());
		if (existing != null) {
			throw new BadRequestException("Country with this Name exists");
		}
		return repository.create(c);
	}

	@Override
	@Transactional
	public Country update(String id, Country c) {
		Country existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Country not found");
		}
		return repository.update(c);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Country existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Country not found");
		}
		repository.delete(existing);
	}
}