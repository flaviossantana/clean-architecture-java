package com.school.clear.domain.aluno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void deveRetornarExcecaoQuandoDDDForInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Telefone("1", "12345678");
        });
    }

    @Test
    void deveRetornarExcecaoQuandoNumeroForInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Telefone("11", "1234567");
        });
    }

    @Test
    void deveriaCriarUmTelefoneValido() {
        Telefone telefone = new Telefone("11", "12345678");
        assertNotNull(telefone.getDdd());
        assertNotNull(telefone.getNumero());
    }

}
