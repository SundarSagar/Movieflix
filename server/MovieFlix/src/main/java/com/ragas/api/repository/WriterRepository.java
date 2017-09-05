package com.ragas.api.repository;

import java.util.List;

import com.ragas.api.entity.Writer;

public interface WriterRepository {

	public List<Writer> findAll();

	public Writer findOne(String id);
	
	public Writer findByName(String Name);

	public Writer create(Writer w);

	public Writer update(Writer w);

	public void delete(Writer w);
}
