package com.hashcorp.dao.names.cache;

import java.util.Arrays;
import java.util.Objects;

public enum CacheSettings {

	DEFAULTS(CacheNames.DEFAULTS, 600),
	;

	private final String cacheName;
	private final int ttl;
	CacheSettings(String cacheName, int ttl) {
		this.cacheName = cacheName;
		this.ttl = ttl;
	}

	public static CacheSettings fromCacheName(String cacheName) {
		return Arrays.stream(values()).filter(cs -> Objects.equals(cs.cacheName, cacheName)).findFirst().orElse(DEFAULTS);
	}

	public String getCacheName() {
		return cacheName;
	}

	public int getTtl() {
		return ttl;
	}

}
