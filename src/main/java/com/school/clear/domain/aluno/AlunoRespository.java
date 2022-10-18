package com.school.clear.domain.aluno;

import java.util.List;

public interface AlunoRespository {
    void matricular(Aluno aluno);
    Aluno buscarPorCPF(CPF cpf);
    List<Aluno> listarTodosAlunosMatriculados();
}
