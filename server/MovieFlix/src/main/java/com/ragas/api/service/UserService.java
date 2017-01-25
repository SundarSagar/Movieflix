package com.ragas.api.service;

//import java.util.List;

import com.ragas.api.entity.User;

public interface UserService {

	//public List<Employee> findAll();

	public User findOne(String id);

	public User create(User u);

	public User update(String id, User u);

	public void delete(String id);
}
