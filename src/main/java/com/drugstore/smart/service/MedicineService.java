package com.drugstore.smart.service;

import com.drugstore.smart.dto.MedicineCreateDTO;
import com.drugstore.smart.dto.MedicineDTO;
import com.drugstore.smart.entity.Medicine;
import com.drugstore.smart.mapper.MedicineMapper;
import com.drugstore.smart.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {
    private final MedicineRepository repository;
    private final MedicineMapper mapper;

    public List<MedicineDTO> getAllMedicines() {
        return mapper.toDTO(repository.findAll());
    }
    
    @Transactional
    public MedicineDTO save(MedicineCreateDTO dto) {
        Medicine newMedicine = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(newMedicine));
    }

    private Medicine getMedicineById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found with id: " + id));
    }

    @Transactional
    public MedicineDTO update(MedicineDTO dto) {
        Medicine entity = getMedicineById(dto.id());
        mapper.updateFromDto(dto, entity);
        return mapper.toDTO(repository.save(entity));
    }
}
