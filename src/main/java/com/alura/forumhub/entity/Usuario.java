package com.alura.forumhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Collate;

import java.util.List;
import java.util.UUID;

@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "senha")
    @NotNull
    private String senha;

    @Column(name = "perfis")
    private String perfis;

    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos;

    @OneToMany(mappedBy = "autor")
    private List<Resposta> respostas;
}
