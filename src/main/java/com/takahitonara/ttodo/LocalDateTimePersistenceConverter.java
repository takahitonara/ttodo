package com.takahitonara.ttodo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimePersistenceConverter implements
		AttributeConverter<LocalDateTime, Timestamp> {
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
		return Timestamp.valueOf(localDateTime);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
		return timestamp.toLocalDateTime();
	}
}