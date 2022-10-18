package com.school.clear.infra.aluno;

import com.school.clear.domain.aluno.Aluno;
import com.school.clear.domain.aluno.AlunoNaoEncontradoException;
import com.school.clear.domain.aluno.AlunoRespository;
import com.school.clear.domain.aluno.CPF;

import java.util.ArrayList;
import java.util.List;

public class AlunoRespositoryMEM implements AlunoRespository {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return this.matriculados.stream()
                .filter(aluno -> aluno.getCpf().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }

}
