package com.ragas.api.service;

import java.util.List;

import com.ragas.api.entity.Country;

public interface CountryService {

	public List<Country> findAll();

	public Country findOne(String id);

	public Country create(Country c);

	public Country update(String id, Country c);

	public void delete(String id);
}
