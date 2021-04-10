package com.hashcorp.delivery.support;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Dates {

	public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	private static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();

	public static OffsetDateTime stringToDate(final String dateStr, DateTimeFormatter dateFormatter) {
		final LocalDate localDate = LocalDate.parse(dateStr, dateFormatter);
		return OffsetDateTime.of(localDate, LocalTime.NOON, ZoneOffset.UTC);
	}

	public static LocalDate stringToLocalDate(final String dateStr, DateTimeFormatter dateFormatter) {
		return LocalDate.parse(dateStr, dateFormatter);
	}

	public static boolean isDayOff(final DayOfWeek dayOfWeek) {
		return dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7;
	}

	public static String dateToString(LocalDate date, DateTimeFormatter dateFormatter) {
		return date.format(dateFormatter);
	}

	public static LocalDateTime fromMilliSeconds(long milliSeconds) {
		return fromMilliSeconds(milliSeconds, DEFAULT_ZONE);
	}

	public static LocalDateTime fromMilliSeconds(long milliSeconds, ZoneId zoneId) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(milliSeconds), zoneId);
	}

	public static long toMilliSeconds(LocalDateTime dateTime) {
		return toMilliSeconds(dateTime, DEFAULT_ZONE);
	}

	public static long toMilliSeconds(LocalDateTime dateTime, ZoneId zoneId) {
		return Optional.ofNullable(dateTime)
			.map(ldt -> ldt.atZone(zoneId))
			.map(ZonedDateTime::toInstant)
			.map(Instant::toEpochMilli)
			.orElse(0L);
	}
}
