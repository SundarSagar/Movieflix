package com.ragas.api.service;

import java.util.List;

import com.ragas.api.entity.Language;

public interface LanguageService {

	public List<Language> findAll();

	public Language findOne(String id);

	public Language create(Language lan);

	public Language update(String id, Language lan);

	public void delete(String id);
}
