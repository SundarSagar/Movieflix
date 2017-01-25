package com.ragas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.api.entity.Writer;
import com.ragas.api.service.WriterService;

@RestController
@RequestMapping(value = "writers")
public class WriterController {

	@Autowired
	private WriterService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Writer> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Writer findOne(@PathVariable("id") String wId) {
		return service.findOne(wId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Writer create(@RequestBody Writer w) {
		return service.create(w);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Writer update(@PathVariable("id") String id, @RequestBody Writer w) {
		return service.update(id, w);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}