package com.ragas.api.service;

import java.util.List;

import com.ragas.api.entity.Writer;

public interface WriterService {

	public List<Writer> findAll();

	public Writer findOne(String id);

	public Writer create(Writer w);

	public Writer update(String id, Writer w);

	public void delete(String id);
}
