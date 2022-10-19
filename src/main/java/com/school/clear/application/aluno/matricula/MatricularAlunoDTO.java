package com.school.clear.application.aluno.matricula;

import com.school.clear.domain.aluno.Aluno;
import com.school.clear.domain.builder.AlunoBuilder;

public class MatricularAlunoDTO {

    private String nome;
    private String cpf;
    private String email;

    public MatricularAlunoDTO(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Aluno criarAluno() {
        return AlunoBuilder.init(cpf, email, nome).build();
    }
}
