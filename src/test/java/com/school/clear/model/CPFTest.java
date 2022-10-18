package com.school.clear.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void deveRetornarExcecaoQuandoCPFForInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CPF("13.456.789-00");
        });
    }

    @Test
    void deveriaCriarUmCPFValido() {
        CPF cpf = new CPF("123.456.789-01");
        assertNotNull(cpf.getNumero());
    }

}
