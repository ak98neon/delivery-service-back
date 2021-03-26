package com.hashcorp.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.hashcorp.core.entity.domain.AbstractEntity;
import com.hashcorp.dao.repository.CommonRepository;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>, ID extends Long>
	implements CommonService<E, ID> {

	protected final R repository;

	protected AbstractService(R repository) {
		this.repository = repository;
	}

	@Override
	public E save(E entity) {
		return repository.save(entity);
	}

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public List<E> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<E> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public <S extends E> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public <S extends E> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<E> entities) {
		repository.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public E getOne(ID id) {
		return repository.getOne(id);
	}

	@Override
	public <S extends E> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	@Override
	public <S extends E> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}
}
