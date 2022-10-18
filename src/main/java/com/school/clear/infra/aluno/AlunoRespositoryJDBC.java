package com.school.clear.infra.aluno;

import com.school.clear.domain.aluno.*;
import com.school.clear.domain.builder.AlunoBuilder;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AlunoRespositoryJDBC implements AlunoRespository {

    private final Connection connection;

    public AlunoRespositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            var sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
            var ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();
            ps.close();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try {
            var sql = "SELECT cpf, nome, email FROM ALUNO WHERE cpf = ?";
            var ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());
            var rs = ps.executeQuery();
            if (!rs.next()) {
                throw new AlunoNaoEncontradoException(cpf);
            }
            return AlunoBuilder.init(
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("nome")
            ).build();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try{
            String sql = "SELECT * FROM ALUNO";
            var ps = connection.prepareStatement(sql);
            var rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while (rs.next()) {
                alunos.add(AlunoBuilder.init(
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("nome")
                ).build());
            }
            return alunos;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
