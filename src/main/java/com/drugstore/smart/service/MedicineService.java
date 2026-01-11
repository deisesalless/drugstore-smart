package com.drugstore.smart.service;

import com.drugstore.smart.dto.MedicineCreateDTO;
import com.drugstore.smart.dto.MedicineDTO;
import com.drugstore.smart.entity.Medicine;
import com.drugstore.smart.mapper.MedicineMapper;
import com.drugstore.smart.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {
    private final MedicineRepository repository;
    private final MedicineMapper mapper;

    public List<Medicine> getAllMedicines() {
        return repository.findAll();
    }

    public MedicineDTO save(MedicineCreateDTO dto) {
        Medicine newMedicine = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(newMedicine));
    }
}
