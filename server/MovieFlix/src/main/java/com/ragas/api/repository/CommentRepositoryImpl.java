package com.ragas.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ragas.api.entity.Comment;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Comment> findAll() {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}

	@Override
	public Comment findOne(String id) {
		return em.find(Comment.class, id);
	}

	@Override
	public Comment findByMovieId(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByMovieId", Comment.class);
		query.setParameter("pMovieId", movieId);

		List<Comment> Comments = query.getResultList();
		if (Comments != null && Comments.size() == 1) {
			return Comments.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Comment create(Comment c) {
		em.persist(c);
		return c;
	}

	@Override
	public Comment update(Comment c) {
		return em.merge(c);
	}

	@Override
	public void delete(Comment c) {
		em.remove(c);
	}
}