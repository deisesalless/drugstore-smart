package com.drugstore.smart.mapper;

import com.drugstore.smart.dto.MedicineCreateDTO;
import com.drugstore.smart.dto.MedicineDTO;
import com.drugstore.smart.entity.Medicine;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MedicineMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    Medicine toEntity(MedicineCreateDTO dto);

    MedicineDTO toDTO(Medicine entity);

    List<MedicineDTO> toDTO(List<Medicine> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(MedicineDTO dto, @MappingTarget Medicine entity);
}
