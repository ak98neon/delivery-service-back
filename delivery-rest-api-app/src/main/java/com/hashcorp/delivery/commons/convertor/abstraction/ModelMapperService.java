package com.hashcorp.delivery.commons.convertor.abstraction;

public interface ModelMapperService {

	<T> T convert(Object source, Class<T> destinationType);

}
