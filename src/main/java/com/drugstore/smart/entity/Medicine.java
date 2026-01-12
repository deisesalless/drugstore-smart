package com.drugstore.smart.entity;

import com.drugstore.smart.enums.Manufacturer;
import com.drugstore.smart.enums.MedicineForm;
import com.drugstore.smart.enums.converter.ManufacturerConverter;
import com.drugstore.smart.enums.converter.MedicineFormConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dosage;

    @Convert(converter = MedicineFormConverter.class)
    private MedicineForm form;

    @Convert(converter = ManufacturerConverter.class)
    private Manufacturer manufacturer;

    private LocalDate expirationDate;
    private BigDecimal price;
    private Integer quantityInStock;
    private String description;
}
