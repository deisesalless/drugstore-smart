package com.drugstore.smart.controller;

import com.drugstore.smart.dto.MedicineCreateDTO;
import com.drugstore.smart.dto.MedicineDTO;
import com.drugstore.smart.service.MedicineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicines")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService service;

    @GetMapping
    public ResponseEntity<List<MedicineDTO>> findAll() {
        return ResponseEntity.ok(service.getAllMedicines());
    }

    @GetMapping("/all/active")
    public ResponseEntity<List<MedicineDTO>> findAllActive() {
        return ResponseEntity.ok(service.getAllActiveMedicines());
    }

    @PostMapping
    public ResponseEntity<MedicineDTO> save(@RequestBody @Valid MedicineCreateDTO dto) {
        MedicineDTO newMedicine = service.save(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newMedicine.id()).toUri();

        return ResponseEntity.created(location).body(newMedicine);
    }

    @PatchMapping
    public ResponseEntity<MedicineDTO> update(@RequestBody @Valid MedicineDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/disable/{id}")
    public ResponseEntity<Void> disable(@PathVariable Integer id) {
        service.disableMedicine(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/enable/{id}")
    public ResponseEntity<Void> enable(@PathVariable Integer id) {
        service.enableMedicine(id);
        return ResponseEntity.noContent().build();
    }
}
