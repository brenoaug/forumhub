package com.alura.forumhub.entity;

import com.alura.forumhub.dto.DadosAtualizacaoTopico;
import com.alura.forumhub.dto.DadosCriacaoTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {
    @Id
    @Column(name = "topico_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "data_criacao")
    private final LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.ABERTO;

    @Column(name = "autor")
    private String autor;

    @Column(name = "curso")
    private String curso;

    public Topico(DadosCriacaoTopico dadosCriacaoTopico) {
        this.titulo = dadosCriacaoTopico.titulo();
        this.mensagem = dadosCriacaoTopico.mensagem();
        this.autor = dadosCriacaoTopico.autor();
        this.curso = dadosCriacaoTopico.curso();
    }

    public Topico() {
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public @NotBlank String setTitulo(@NotBlank String titulo) {
        return this.titulo = titulo;
    }
    public @NotBlank String setMensagem(@NotBlank String mensagem) {
        return this.mensagem = mensagem;
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dadosAtualizados) {
        if (dadosAtualizados.titulo() != null && !dadosAtualizados.titulo().isBlank()) {
            setTitulo(dadosAtualizados.titulo());
        }
        if (dadosAtualizados.mensagem() != null && !dadosAtualizados.mensagem().isBlank()) {
            setMensagem(dadosAtualizados.mensagem());
        }
    }
}
