package com.hashcorp.delivery.commons.convertor.abstraction;

public interface BackwardConverter<E, DTO> {

	E convertBackward(DTO dto);

	boolean supports(Class<? extends E> clazz);
}
