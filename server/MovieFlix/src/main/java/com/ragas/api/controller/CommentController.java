package com.ragas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.api.entity.Comment;
import com.ragas.api.service.CommentService;

@RestController
@RequestMapping(value = "comments")
public class CommentController {

	@Autowired
	private CommentService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Comment> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Comment findOne(@PathVariable("id") String cId) {
		return service.findOne(cId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Comment create(@RequestBody Comment c) {
		return service.create(c);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Comment update(@PathVariable("id") String id, @RequestBody Comment c) {
		return service.update(id, c);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}