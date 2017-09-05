package com.ragas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.api.entity.Genre;
import com.ragas.api.service.GenreService;

@RestController
@RequestMapping(value = "genres")
public class GenreController {

	@Autowired
	private GenreService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Genre> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Genre findOne(@PathVariable("id") String genId) {
		return service.findOne(genId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Genre create(@RequestBody Genre gen) {
		return service.create(gen);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Genre update(@PathVariable("id") String id, @RequestBody Genre gen) {
		return service.update(id, gen);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}