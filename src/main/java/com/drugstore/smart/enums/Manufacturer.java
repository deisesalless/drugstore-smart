package com.drugstore.smart.enums;

import lombok.Getter;

@Getter
public enum Manufacturer {
    PFIZER(1, "Pfizer"),
    NOVARTIS(2, "Novartis"),
    EMS(3, "EMS"),
    HIPOLABO(4, "Hipolabo"),
    SANOFI(5, "Sanofi"),
    AGENCIA_NACIONAL(6, "Eurofarma"),
    TEUTO(7, "Teuto"),
    MERCK(8, "Merck"),
    BAYER(9, "Bayer"),
    ASTRAZENECA(10, "AstraZeneca");

    private final int code;
    private final String displayName;

    Manufacturer(int code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    // Utilitário para converter código do banco para enum
    public static Manufacturer fromCode(int code) {
        for (Manufacturer m : Manufacturer.values()) {
            if (m.getCode() == code) {
                return m;
            }
        }
        throw new IllegalArgumentException("Código inválido para Manufacturer: " + code);
    }
}
