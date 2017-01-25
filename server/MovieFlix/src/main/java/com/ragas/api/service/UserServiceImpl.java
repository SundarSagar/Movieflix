package com.ragas.api.service;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragas.api.entity.User;
import com.ragas.api.exception.BadRequestException;
import com.ragas.api.exception.EntityNotFoundException;
import com.ragas.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	/*
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return repository.findAll();
	}
	*/

	@Override
	@Transactional(readOnly = true)
	public User findOne(String id) {
		User u = repository.findOne(id);
		if (u == null) {
			throw new EntityNotFoundException("User not found");
		}
		return u;
	}

	@Override
	@Transactional
	public User create(User u) {
		User existing = repository.findByEmail(u.getEmail());
		if (existing != null) {
			throw new BadRequestException("User with this email already exists");
		}
		return repository.create(u);
	}

	@Override
	@Transactional
	public User update(String id, User u) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		return repository.update(u);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		repository.delete(existing);
	}
}