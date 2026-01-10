package com.drugstore.smart.persistence.converter;

import com.drugstore.smart.enums.Manufacturer;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ManufacturerConverter implements AttributeConverter<Manufacturer, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Manufacturer attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public Manufacturer convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : Manufacturer.fromCode(dbData);
    }
}
