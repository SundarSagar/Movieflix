package com.ragas.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ragas.api.entity.Language;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Language> findAll() {
		TypedQuery<Language> query = em.createNamedQuery("Language.findAll", Language.class);
		return query.getResultList();
	}

	@Override
	public Language findOne(String id) {
		return em.find(Language.class, id);
	}

	@Override
	public Language findByName(String name) {
		TypedQuery<Language> query = em.createNamedQuery("Language.findByName", Language.class);
		query.setParameter("pName", name);

		List<Language> Languages = query.getResultList();
		if (Languages != null && Languages.size() == 1) {
			return Languages.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Language create(Language lan) {
		em.persist(lan);
		return lan;
	}

	@Override
	public Language update(Language lan) {
		return em.merge(lan);
	}

	@Override
	public void delete(Language lan) {
		em.remove(lan);
	}
}