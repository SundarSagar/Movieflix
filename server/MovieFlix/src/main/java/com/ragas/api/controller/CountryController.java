package com.ragas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.api.entity.Country;
import com.ragas.api.service.CountryService;

@RestController
@RequestMapping(value = "countrys")
public class CountryController {

	@Autowired
	private CountryService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Country> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Country findOne(@PathVariable("id") String actId) {
		return service.findOne(actId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Country create(@RequestBody Country act) {
		return service.create(act);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Country update(@PathVariable("id") String id, @RequestBody Country act) {
		return service.update(id, act);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}