package com.school.clear.facade.aluno;

public interface CifradorSenha {
        String cifrarSenha(String senha);
        boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
