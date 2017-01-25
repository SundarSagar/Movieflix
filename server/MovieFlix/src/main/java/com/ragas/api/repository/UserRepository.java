package com.ragas.api.repository;

//import java.util.List;

import com.ragas.api.entity.User;

public interface UserRepository {

	//public List<User> findAll();

	public User findOne(String id);
	
	public User findByEmail(String email);

	public User create(User u);

	public User update(User u);

	public void delete(User u);
}
