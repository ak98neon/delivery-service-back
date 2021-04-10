package com.hashcorp.delivery.convertor.abstraction;

public interface BackwardConverter<E, DTO> {

	E convertBackward(DTO dto);

	boolean supports(Class<? extends E> clazz);
}
