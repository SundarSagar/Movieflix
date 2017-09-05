package com.ragas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.api.entity.Actor;
import com.ragas.api.service.ActorService;

@RestController
@RequestMapping(value = "actors")
public class ActorController {

	@Autowired
	private ActorService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Actor> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Actor findOne(@PathVariable("id") String actId) {
		return service.findOne(actId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Actor create(@RequestBody Actor act) {
		return service.create(act);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Actor update(@PathVariable("id") String id, @RequestBody Actor act) {
		return service.update(id, act);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}