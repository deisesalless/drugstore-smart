package com.drugstore.smart.enums.converter;

import com.drugstore.smart.enums.MedicineForm;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MedicineFormConverter implements AttributeConverter<MedicineForm, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MedicineForm attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public MedicineForm convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : MedicineForm.fromCode(dbData);
    }
}
