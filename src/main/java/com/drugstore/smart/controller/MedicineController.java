package com.drugstore.smart.controller;

import com.drugstore.smart.dto.MedicineDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedios")
public class MedicineController {

    @PostMapping
    public void saveMedicine(@RequestBody MedicineDTO json) {
        System.out.println(json);
    }
}
