package com.ragas.api.repository;

import java.util.List;

import com.ragas.api.entity.Language;

public interface LanguageRepository {

	public List<Language> findAll();

	public Language findOne(String id);
	
	public Language findByName(String name);

	public Language create(Language lan);

	public Language update(Language lan);

	public void delete(Language lan);
}
