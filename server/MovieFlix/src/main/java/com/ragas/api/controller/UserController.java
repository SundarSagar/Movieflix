package com.ragas.api.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ragas.api.entity.User;
import com.ragas.api.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;

	/*
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}
	*/

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public User findOne(@PathVariable("id") String uId) {
		return service.findOne(uId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User u) {
		return service.create(u);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public User update(@PathVariable("id") String id, @RequestBody User u) {
		return service.update(id, u);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}