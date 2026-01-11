package com.drugstore.smart.dto;

import com.drugstore.smart.enums.Manufacturer;
import com.drugstore.smart.enums.MedicineForm;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MedicineRequestDTO(
    String name,
    String dosage,
    MedicineForm form,
    Manufacturer manufacturer,
    LocalDate expirationDate,
    BigDecimal price,
    Integer quantityInStock,
    String description
) {
}
