package com.alura.forumhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String titulo;

    @Column(name = "mensagem")
    @NotBlank
    private String mensagem;

    @Column(name = "data_criacao")
    @NotNull
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusTopico status = StatusTopico.ABERTO;

    @Column(name = "autor")
    @NotBlank
    private String autor;

    @Column(name = "curso")
    private String curso;
}
