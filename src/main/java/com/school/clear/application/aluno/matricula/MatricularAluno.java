package com.school.clear.application.aluno.matricula;

import com.school.clear.domain.aluno.Aluno;
import com.school.clear.facade.aluno.AlunoRespository;

public class MatricularAluno {

    private final AlunoRespository alunoRespository;

    public MatricularAluno(AlunoRespository alunoRespository) {
        this.alunoRespository = alunoRespository;
    }

    public void criar(MatricularAlunoDTO dados) {
        Aluno aluno = dados.criarAluno();
        alunoRespository.matricular(aluno);
    }

}
