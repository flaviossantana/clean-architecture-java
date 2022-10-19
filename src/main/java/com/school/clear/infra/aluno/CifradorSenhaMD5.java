package com.school.clear.infra.aluno;

import com.school.clear.facade.aluno.CifradorSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorSenhaMD5 implements CifradorSenha {

    @Override
    public String cifrarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02X", 0xFF & b));
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao cifrar senha");
        }
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return senhaCifrada.equals(cifrarSenha(senha));
    }

}
