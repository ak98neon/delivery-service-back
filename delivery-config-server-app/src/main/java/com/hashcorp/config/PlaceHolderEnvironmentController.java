package com.hashcorp.config;

import static org.springframework.cloud.config.server.support.EnvironmentPropertySource.resolvePlaceholders;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentController;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(method = RequestMethod.GET, path = "resolved/${spring.cloud.config.server.prefix:}")
@Slf4j
public class PlaceHolderEnvironmentController extends EnvironmentController {

	@Autowired
	public PlaceHolderEnvironmentController(EnvironmentRepository repository) {
		super(repository);
	}

	public PlaceHolderEnvironmentController(EnvironmentRepository repository, ObjectMapper objectMapper) {
		super(repository, objectMapper);
	}

	@Override
	public Environment getEnvironment(String name, String profiles, String label, boolean includeOrigin) {
		log.info("Resolved controller call: " + name + " " + profiles + " label");
		return resolvePlaceHolders(super.getEnvironment(name, profiles, label, includeOrigin));
	}

	private Environment resolvePlaceHolders(Environment environment) {

		StandardEnvironment standardEnvironment = new StandardEnvironment();

		List<PropertySource> propertySources = environment.getPropertySources();

		List<PropertySource> newSources = environment.getPropertySources().stream()
			.map(source -> resolvePlaceHolders(source, standardEnvironment)).collect(Collectors.toList());

		propertySources.clear();
		propertySources.addAll(newSources);
		return environment;
	}

	private PropertySource resolvePlaceHolders(PropertySource propertySource, StandardEnvironment standardEnvironment) {

		Map<?, String> map = propertySource.getSource().entrySet().stream()
			.collect(Collectors.toMap(Entry::getKey, v -> resolvePlaceholders(standardEnvironment, v.getValue().toString())));

		return new PropertySource(propertySource.getName(), map);
	}

}
