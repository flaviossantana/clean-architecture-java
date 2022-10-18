package com.school.clear.domain.builder;

import com.school.clear.domain.aluno.Aluno;
import com.school.clear.domain.aluno.CPF;
import com.school.clear.domain.aluno.Email;
import com.school.clear.domain.aluno.Telefone;

import java.util.ArrayList;
import java.util.List;

public class AlunoBuilder {

    private CPF cpf;
    private Email email;
    private String nome;
    private List<Telefone> telefones = new ArrayList<>();


    public static AlunoBuilder init(String cpf, String email, String nome) {
        return new AlunoBuilder()
                .cpf(cpf)
                .email(email)
                .nome(nome);
    }

    protected AlunoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    protected AlunoBuilder cpf(String cpf) {
        this.cpf = new CPF(cpf);
        return this;
    }

    protected AlunoBuilder email(String email) {
        this.email = new Email(email);
        return this;
    }

    public AlunoBuilder telefone(String ddd, String numero) {
        this.telefones.add(new Telefone(ddd, numero));
        return this;
    }

    public Aluno build() {
        Aluno aluno = new Aluno(nome, cpf, email);
        this.telefones.forEach(aluno::adicionarTelefone);
        return aluno;
    }

}
