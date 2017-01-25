package com.ragas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragas.api.entity.Actor;
import com.ragas.api.exception.BadRequestException;
import com.ragas.api.exception.EntityNotFoundException;
import com.ragas.api.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Actor> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Actor findOne(String id) {
		Actor act = repository.findOne(id);
		if (act == null) {
			throw new EntityNotFoundException("Actor not found");
		}
		return act;
	}

	@Override
	@Transactional
	public Actor create(Actor act) {
		Actor existing = repository.findByName(act.getName());
		if (existing != null) {
			throw new BadRequestException("Actor with this email already exists");
		}
		return repository.create(act);
	}

	@Override
	@Transactional
	public Actor update(String id, Actor act) {
		Actor existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Actor not found");
		}
		return repository.update(act);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Actor existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Actor not found");
		}
		repository.delete(existing);
	}
}