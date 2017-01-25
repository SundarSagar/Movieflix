package com.ragas.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ragas.api.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findOne(String title) {
		return em.find(Movie.class, title);
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByEmail", Movie.class);
		query.setParameter("pTitle", title);

		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	

	@Override
	public Movie create(Movie m) {
		em.persist(m);
		return m;
	}

	@Override
	public Movie update(Movie m) {
		return em.merge(m);
	}

	@Override
	public void delete(Movie m) {
		em.remove(m);
	}
}