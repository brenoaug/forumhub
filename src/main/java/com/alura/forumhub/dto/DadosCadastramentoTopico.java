package com.alura.forumhub.dto;

import com.alura.forumhub.entity.StatusTopico;
import com.alura.forumhub.entity.Topico;

import java.util.UUID;

public record DadosCadastramentoTopico(
        UUID id,
        String titulo,
        String mensagem,
        String autor,
        String curso,
        StatusTopico status,
        String dataCriacao
) {
    public DadosCadastramentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getStatus(),
                topico.getDataCriacao().toString()
        );
    }
}
