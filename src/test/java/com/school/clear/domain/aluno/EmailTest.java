package com.school.clear.domain.aluno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void deveRetornarExcecaoQuandoEmailForInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Email("emailinvalido");
        });
    }

    @Test
    void deveriaCriarUmEmailValido() {
        Email email = new Email("email@email.com");
        assertNotNull(email.getEndereco());
    }

}
