package com.ragas.api.service;

import java.util.List;

import com.ragas.api.entity.Actor;

public interface ActorService {

	public List<Actor> findAll();

	public Actor findOne(String id);

	public Actor create(Actor act);

	public Actor update(String id, Actor act);

	public void delete(String id);
}
