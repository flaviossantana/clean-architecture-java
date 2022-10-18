package com.school.clear.domain.aluno;

public class AlunoNaoEncontradoException extends RuntimeException {
    public AlunoNaoEncontradoException(CPF cpf) {
        super("Aluno não encontrado para o CPF " + cpf.getNumero());
    }
}
