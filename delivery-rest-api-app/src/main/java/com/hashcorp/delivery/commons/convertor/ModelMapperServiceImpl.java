package com.hashcorp.delivery.commons.convertor;

import static com.hashcorp.delivery.support.Dates.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.hashcorp.delivery.commons.convertor.abstraction.ModelMapperService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService {

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private final ModelMapper modelMapper;

	@PostConstruct
	private void init() {
		Converter<LocalDateTime, Long> localDateTimeToLongConverter = context -> toMilliSeconds(context.getSource());
		modelMapper.addConverter(localDateTimeToLongConverter);
		Converter<Long, LocalDateTime> longToLocalDateTimeConverter = context -> fromMilliSeconds(context.getSource());
		modelMapper.addConverter(longToLocalDateTimeConverter);

		modelMapper.typeMap(String.class, LocalDate.class).setConverter(context -> LocalDate.parse(context.getSource(), DATE_FORMAT));
		modelMapper.typeMap(LocalDate.class, String.class).setConverter(context -> DATE_FORMAT.format(context.getSource()));
	}

	@Override
	public <T> T convert(Object source, Class<T> destinationType) {
		return modelMapper.map(source, destinationType);
	}

}
