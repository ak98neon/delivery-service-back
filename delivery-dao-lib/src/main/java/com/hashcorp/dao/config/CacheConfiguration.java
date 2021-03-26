package com.hashcorp.dao.config;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.hashcorp.dao.names.cache.CacheSettings;

@Configuration
@EnableCaching
@ConditionalOnProperty(
	value = "spring.cache.enabled",
	matchIfMissing = true)
public class CacheConfiguration {

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		return RedisCacheManager.builder(redisConnectionFactory)
			.cacheDefaults(buildFromSettings(CacheSettings.DEFAULTS))
			.withInitialCacheConfigurations(buildFromSettings())
			.build();
	}

	private Map<String, RedisCacheConfiguration> buildFromSettings() {
		return Arrays.stream(CacheSettings.values()).collect(Collectors.toMap(CacheSettings::getCacheName, this::buildFromSettings));
	}

	private RedisCacheConfiguration buildFromSettings(CacheSettings cacheSettings) {
		return RedisCacheConfiguration.defaultCacheConfig()
			.prefixKeysWith(cacheSettings.getCacheName())
			.entryTtl(Duration.ofSeconds(cacheSettings.getTtl()));
	}

}
