package com.ragas.api.service;

import java.util.List;

import com.ragas.api.entity.Comment;

public interface CommentService {

	public List<Comment> findAll();

	public Comment findOne(String id);

	public Comment create(Comment c);

	public Comment update(String id, Comment c);

	public void delete(String id);
}
