package com.drugstore.smart.dto;

import com.drugstore.smart.enums.Manufacturer;
import com.drugstore.smart.enums.MedicineForm;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MedicineDTO(
        @NotNull Integer id,
        @NotBlank(message = "Name is required") String name,
        String dosage,
        @Enumerated MedicineForm form,
        @Enumerated Manufacturer manufacturer,
        LocalDate expirationDate,
        @NotNull(message = "Price is required") BigDecimal price,
        Integer quantityInStock,
        @NotBlank(message = "Description is required") String description,
        Boolean isActive
) {
}
