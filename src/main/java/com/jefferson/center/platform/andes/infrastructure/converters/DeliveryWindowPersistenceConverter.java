package com.jefferson.center.platform.andes.infrastructure.converters;

import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryWindow;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Converter
public class DeliveryWindowPersistenceConverter implements AttributeConverter<DeliveryWindow, String> {
    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(DeliveryWindow window) {
        return window != null
                ? window.startDate() + SEPARATOR + window.endDate()
                : null;
    }

    @Override
    public DeliveryWindow convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        try {
            String[] dates = value.split(SEPARATOR, -1);
            if (dates.length != 2) {
                throw new IllegalArgumentException("Invalid delivery window value");
            }
            return new DeliveryWindow(
                    LocalDate.parse(dates[0].trim()),
                    LocalDate.parse(dates[1].trim())
            );
        } catch (DateTimeParseException | IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid delivery window value: " + value, exception);
        }
    }
}
