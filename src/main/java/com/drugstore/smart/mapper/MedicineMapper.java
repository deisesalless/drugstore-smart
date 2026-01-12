package com.drugstore.smart.mapper;

import com.drugstore.smart.dto.MedicineCreateDTO;
import com.drugstore.smart.dto.MedicineDTO;
import com.drugstore.smart.entity.Medicine;
import com.drugstore.smart.enums.Manufacturer;
import com.drugstore.smart.enums.MedicineForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MedicineMapper {

    @Mapping(target = "id", ignore = true)
    Medicine toEntity(MedicineCreateDTO dto);
    MedicineDTO toDTO(Medicine entity);
    List<MedicineDTO> toDTO(List<Medicine> entities);
}
