package com.ragas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragas.api.entity.Language;
import com.ragas.api.exception.BadRequestException;
import com.ragas.api.exception.EntityNotFoundException;
import com.ragas.api.repository.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Language> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Language findOne(String id) {
		Language lan = repository.findOne(id);
		if (lan == null) {
			throw new EntityNotFoundException("Language not found");
		}
		return lan;
	}

	@Override
	@Transactional
	public Language create(Language lan) {
		Language existing = repository.findByName(lan.getName());
		if (existing != null) {
			throw new BadRequestException("Language with this Name already exists");
		}
		return repository.create(lan);
	}

	@Override
	@Transactional
	public Language update(String id, Language lan) {
		Language existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Language not found");
		}
		return repository.update(lan);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Language existing = repository.findOne(id);
		if (existing == null) {
			throw new EntityNotFoundException("Language not found");
		}
		repository.delete(existing);
	}
}