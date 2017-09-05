package com.ragas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragas.api.entity.Comment;
//import com.ragas.api.exception.BadRequestException;
import com.ragas.api.exception.EntityNotFoundException;
import com.ragas.api.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Comment> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Comment findOne(String id) {
		Comment c = repository.findOne(id);
		if (c == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		return c;
	}

	@Override
	@Transactional
	public Comment create(Comment c) {
		return repository.create(c);
	}

	@Override
	@Transactional
	public Comment update(String id, Comment c) {
		Comment existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		return repository.update(c);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Comment existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		repository.delete(existing);
	}
}