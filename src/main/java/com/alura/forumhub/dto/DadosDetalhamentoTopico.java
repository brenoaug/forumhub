package com.alura.forumhub.dto;

import com.alura.forumhub.entity.StatusTopico;
import com.alura.forumhub.entity.Topico;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

public record DadosDetalhamentoTopico(
        UUID id,
        String titulo,
        String mensagem,
        String autor,
        String curso,
        StatusTopico status,
        String dataCriacao
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getStatus(),
                topico.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
        );
    }
}
