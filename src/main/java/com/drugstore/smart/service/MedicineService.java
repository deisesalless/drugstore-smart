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

    public List<MedicineDTO> getAllActiveMedicines() {
        return mapper.toDTO(repository.findByIsActiveTrue());
    }
    
    @Transactional
    public MedicineDTO save(MedicineCreateDTO dto) {
        Medicine newMedicine = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(newMedicine));
    }

    public MedicineDTO getMedicineById(Integer id) {
        var medicine = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found with id: " + id));

        return mapper.toDTO(medicine);
    }

    private Medicine getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found with id: " + id));
    }

    @Transactional
    public MedicineDTO update(Integer id, MedicineCreateDTO dto) {
        Medicine entityFound = getById(id);
        Medicine entityUpdate = mapper.toEntity(dto);
        entityUpdate.setId(entityFound.getId());
        entityUpdate.setIsActive(entityFound.getIsActive());
        return mapper.toDTO(repository.save(entityUpdate));
    }

    @Transactional
    public void disableMedicine(Integer id) {
        Medicine medicine = getById(id);
        medicine.setIsActive(false);
        repository.save(medicine);
    }

    @Transactional
    public void enableMedicine(Integer id) {
        Medicine medicine = getById(id);
        medicine.setIsActive(true);
        repository.save(medicine);
    }
}
