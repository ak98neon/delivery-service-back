package com.hashcorp.delivery.convertor.abstraction;

public interface ForwardConverter<E, DTO> {

	DTO convert(E entity);

	boolean supports(Class<? extends E> clazz);

}
