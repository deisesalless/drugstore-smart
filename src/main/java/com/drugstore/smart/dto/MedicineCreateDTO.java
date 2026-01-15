package com.drugstore.smart.dto;

import com.drugstore.smart.enums.Manufacturer;
import com.drugstore.smart.enums.MedicineForm;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MedicineCreateDTO(
    @NotBlank(message = "Name is required") String name,
    @NotBlank(message = "Dosage is required") String dosage,
    @Enumerated @NotNull(message = "Form is required") MedicineForm form,
    @Enumerated @NotNull(message = "Manufacturer is required") Manufacturer manufacturer,
    @Future(message = "Expiration date must be in the future") LocalDate expirationDate,
    @NotNull(message = "Price is required") BigDecimal price,
    @Min(value = 1, message = "Minimium quantity is 1") Integer quantityInStock,
    @NotBlank(message = "Description is required") String description
) {
}
