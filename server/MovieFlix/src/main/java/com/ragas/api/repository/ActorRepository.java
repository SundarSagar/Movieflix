package com.ragas.api.repository;

import java.util.List;

import com.ragas.api.entity.Actor;

public interface ActorRepository {

	public List<Actor> findAll();

	public Actor findOne(String id);
	
	public Actor findByName(String name);

	public Actor create(Actor act);

	public Actor update(Actor act);

	public void delete(Actor act);
}
