package com.ragas.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ragas.api.entity.Country;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Country> findAll() {
		TypedQuery<Country> query = em.createNamedQuery("Country.findAll", Country.class);
		return query.getResultList();
	}

	@Override
	public Country findOne(String id) {
		return em.find(Country.class, id);
	}

	@Override
	public Country findByName(String Name) {
		TypedQuery<Country> query = em.createNamedQuery("Country.findByName", Country.class);
		query.setParameter("pName", Name);

		List<Country> Countrys = query.getResultList();
		if (Countrys != null && Countrys.size() == 1) {
			return Countrys.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Country create(Country c) {
		em.persist(c);
		return c;
	}

	@Override
	public Country update(Country c) {
		return em.merge(c);
	}

	@Override
	public void delete(Country c) {
		em.remove(c);
	}
}