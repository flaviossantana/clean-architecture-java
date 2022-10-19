package com.school.clear.application.aluno.matricula;

import com.school.clear.domain.aluno.Aluno;
import com.school.clear.domain.aluno.CPF;
import com.school.clear.infra.aluno.AlunoRespositoryMEM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    private AlunoRespositoryMEM alunoRespositoryMEM;

    @BeforeEach
    public void contextLoads() {
        alunoRespositoryMEM = new AlunoRespositoryMEM();
    }

    @Test
    void deveriaMatricularAluno() {

        MatricularAluno matricularAluno = new MatricularAluno(this.alunoRespositoryMEM);

        MatricularAlunoDTO fulano = new MatricularAlunoDTO(
                "Fulano",
                "123.456.789-00",
                "fulano@email.com");

        matricularAluno.criar(fulano);

        Aluno aluno = alunoRespositoryMEM.buscarPorCPF(new CPF(fulano.getCpf()));

        Assertions.assertEquals(fulano.getNome(), aluno.getNome());
        Assertions.assertEquals(fulano.getCpf(), aluno.getCpf());
        Assertions.assertEquals(fulano.getEmail(), aluno.getEmail());

    }
}
