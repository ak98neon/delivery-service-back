package com.hashcorp.delivery.convertor.abstraction;

public interface ModelMapperService {

	<T> T convert(Object source, Class<T> destinationType);

}
