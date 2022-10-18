package com.school.clear.domain.aluno;

import com.school.clear.domain.builder.AlunoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    public void setup() {
        aluno = AlunoBuilder
                .init("123.456.789-00", "joao@email.com", "Joao da Silva")
                .build();
    }

    @Test
    void deveriaCriarUmAlunoValido() {
        assertNotNull(aluno.getNome());
        assertNotNull(aluno.getEmail());
        assertNotNull(aluno.getCpf());
    }

    @Test
    void deveriaAdicionarUmTelefoneAoAluno() {
        aluno = AlunoBuilder
                .init("123.456.789-00", "joao@email.com", "Joao da Silva")
                .telefone("11", "999999999")
                .build();

        assertEquals(1, aluno.getTelefones().size());
    }

    @Test
    void deveriaRetornarExcecaoDeCpfInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AlunoBuilder
                    .init("123.456.79-00", "joao@email.com", "Joao da Silva")
                    .build();
        });
    }

}
