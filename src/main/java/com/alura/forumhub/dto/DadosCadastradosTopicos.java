package com.alura.forumhub.dto;

import com.alura.forumhub.entity.StatusTopico;
import com.alura.forumhub.entity.Topico;

import java.time.format.DateTimeFormatter;

public record DadosCadastradosTopicos(
        String titulo,
        String mensagem,
        String dataCriacao,
        StatusTopico status,
        String autor,
        String curso
) {
        public DadosCadastradosTopicos(Topico topico) {
            this(
                    topico.getTitulo(),
                    topico.getMensagem(),
                    topico.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                    topico.getStatus(),
                    topico.getAutor(),
                    topico.getCurso());
        }
}
