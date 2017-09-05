package com.ragas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragas.api.entity.Writer;
import com.ragas.api.exception.BadRequestException;
import com.ragas.api.exception.EntityNotFoundException;
import com.ragas.api.repository.WriterRepository;

@Service
public class WriterServiceImpl implements WriterService {

	@Autowired
	private WriterRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Writer> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Writer findOne(String id) {
		Writer w = repository.findOne(id);
		if (w == null) {
			throw new EntityNotFoundException("Writer not found");
		}
		return w;
	}

	@Override
	@Transactional
	public Writer create(Writer w) {
		Writer existing = repository.findByName(w.getName());
		if (existing != null) {
			throw new BadRequestException("Writer with this Name already exists");
		}
		return repository.create(w);
	}

	@Override
	@Transactional
	public Writer update(String id, Writer w) {
		Writer existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Writer not found");
		}
		return repository.update(w);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Writer existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Writer not found");
		}
		repository.delete(existing);
	}
}