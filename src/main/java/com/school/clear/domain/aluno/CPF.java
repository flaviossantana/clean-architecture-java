package com.school.clear.domain.aluno;

public class CPF {

    private String numero;

    public CPF(String numero) {
        if (isCPFInvalido(numero)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.numero = numero;
    }

    private boolean isCPFInvalido(String numero) {
        return numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    public String getNumero() {
        return numero;
    }
}
