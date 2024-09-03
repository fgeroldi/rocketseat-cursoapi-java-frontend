package com.felipegeroldi.cursosfront.modules.curso.dto;

public enum Status {
    ATIVO ("Ativo"),
    INATIVO ("Inativo");

    public String label;

    private Status(String label) {
        this.label = label;
    }
}
