package com.drugstore.smart.enums;

import lombok.Getter;

@Getter
public enum MedicineForm {
    TABLET(1),
    CAPSULE(2),
    SYRUP(3),
    OINTMENT(4),
    INJECTION(5),
    DROPS(6),
    POWDER(7),
    GEL(8);

    private final int code;

    MedicineForm(int code) {
        this.code = code;
    }

    // Utilitário para converter código do banco para enum
    public static MedicineForm fromCode(int code) {
        for (MedicineForm form : MedicineForm.values()) {
            if (form.getCode() == code) {
                return form;
            }
        }
        throw new IllegalArgumentException("Código inválido para MedicineForm: " + code);
    }
}

