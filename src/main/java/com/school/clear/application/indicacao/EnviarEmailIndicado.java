package com.school.clear.application.indicacao;

import com.school.clear.domain.aluno.Aluno;

public interface EnviarEmailIndicado {
    void enviarPara(Aluno indicado);
}
