package com.school.clear.model;

public class Email {

    private String endereco;

    public Email(String endereco) {
        if (isEmailInvalido(endereco)) {
            throw new IllegalArgumentException("Endereço de email inválido");
        }

        this.endereco = endereco;
    }

    private static boolean isEmailInvalido(String endereco) {
        return endereco == null ||
                !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}
