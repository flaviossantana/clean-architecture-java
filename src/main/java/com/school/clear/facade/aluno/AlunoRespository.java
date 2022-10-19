package com.school.clear.facade.aluno;

import com.school.clear.domain.aluno.Aluno;
import com.school.clear.domain.aluno.CPF;

import java.util.List;

public interface AlunoRespository {
    void matricular(Aluno aluno);
    Aluno buscarPorCPF(CPF cpf);
    List<Aluno> listarTodosAlunosMatriculados();
}
