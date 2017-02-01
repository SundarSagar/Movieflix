package com.ragas.api.repository;

import java.util.List;

import com.ragas.api.entity.Country;

public interface CountryRepository {

	public List<Country> findAll();

	public Country findOne(String id);
	
	public Country findByName(String name);

	public Country create(Country c);

	public Country update(Country c);

	public void delete(Country c);
}
