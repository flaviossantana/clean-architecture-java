package com.school.clear.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    public void setup() {
        aluno = new Aluno("João", new CPF("123.456.789-01"), new Email("silva@email.com"));
    }

    @Test
    void deveriaCriarUmAlunoValido() {
        assertNotNull(aluno.getNome());
        assertNotNull(aluno.getEmail());
        assertNotNull(aluno.getCpf());
    }

    @Test
    void deveriaAdicionarUmTelefoneAoAluno() {
        aluno.adicionarTelefone("11", "12345678");
        assertEquals(1, aluno.getTelefones().size());
    }

    @Test
    void deveriaRetornarExcecaoDeCpfInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Aluno("João", new CPF("123.456.89-01"), new Email("silva@email.com"));
        });
    }

}
