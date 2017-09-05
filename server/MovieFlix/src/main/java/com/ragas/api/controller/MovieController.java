package com.ragas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.api.entity.Movie;
import com.ragas.api.service.MovieService;

@RestController
@RequestMapping(value= "movies")
public class MovieController {
	@Autowired
	private MovieService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Movie findOne(@PathVariable("id") String mId) {
		return service.findOne(mId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Movie create(@RequestBody Movie m) {
		return service.create(m);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Movie update(@PathVariable("id") String id, @RequestBody Movie m) {
		return service.update(id, m);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	

}
