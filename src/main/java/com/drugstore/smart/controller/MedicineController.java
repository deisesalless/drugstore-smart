package com.drugstore.smart.controller;

import com.drugstore.smart.dto.MedicineCreateDTO;
import com.drugstore.smart.dto.MedicineDTO;
import com.drugstore.smart.entity.Medicine;
import com.drugstore.smart.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remedios")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService service;

    @GetMapping
    public List<Medicine> findAll() {
        return service.getAllMedicines();
    }

    @PostMapping
    public ResponseEntity<MedicineDTO> save(@RequestBody MedicineCreateDTO dto) {
        MedicineDTO newMedicine = service.save(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newMedicine.id()).toUri();

        return ResponseEntity.created(location).body(newMedicine);
    }
}
