package com.alura.forumhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@Entity(name = "Curso")
@Table(name = "cursos")
public class Curso {
    @Id
    @Column(name = "curso_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "categoria")
    private String categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;
}
