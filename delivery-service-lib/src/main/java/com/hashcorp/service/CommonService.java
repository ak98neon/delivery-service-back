package com.hashcorp.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.hashcorp.core.entity.domain.AbstractEntity;

public interface CommonService<E extends AbstractEntity, ID> {

	E save(E entity);

	List<E> findAll();

	List<E> findAll(Sort sort);

	List<E> findAllById(Iterable<Long> ids);

	<S extends E> List<S> saveAll(Iterable<S> entities);

	void flush();

	<S extends E> S saveAndFlush(S entity);

	void deleteInBatch(Iterable<E> entities);

	void deleteAllInBatch();

	E getOne(ID id);

	<S extends E> List<S> findAll(Example<S> example);

	<S extends E> List<S> findAll(Example<S> example, Sort sort);
}
