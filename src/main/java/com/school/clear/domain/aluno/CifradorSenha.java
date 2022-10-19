package com.school.clear.domain.aluno;

public interface CifradorSenha {
        String cifrarSenha(String senha);
        boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
