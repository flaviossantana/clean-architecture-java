package com.school.clear.model;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if (isDDDInvalido(ddd)) {
            throw new IllegalArgumentException("DDD inválido");
        }

        if(isNumeroInvalido(numero)) {
            throw new IllegalArgumentException("Telefone inválido");
        }

        this.ddd = ddd;
        this.numero = numero;
    }

    private boolean isNumeroInvalido(String numero) {
        return numero == null || (!numero.matches("\\d{8}") && !numero.matches("\\d{9}"));
    }

    private boolean isDDDInvalido(String ddd) {
        return ddd == null || !ddd.matches("\\d{2}");
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
