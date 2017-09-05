package com.ragas.api.repository;

import java.util.List;

import com.ragas.api.entity.Comment;

public interface CommentRepository {

	public List<Comment> findAll();

	public Comment findOne(String id);
	
	public Comment findByMovieId(String movieId);

	public Comment create(Comment c);

	public Comment update(Comment c);

	public void delete(Comment c);
}
