package com.alura.forumhub.entity;

import com.alura.forumhub.entity.enums.StatusTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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
    @NotNull
    private String titulo;

    @Column(name = "mensagem")
    @NotNull
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.ABERTO;

    @Column(name = "autor")
    private String autor;

    @Column(name = "curso")

    private String curso;

    @Column(name = "respostas")
    private String respostas;

    public Topico() {
    }
}
