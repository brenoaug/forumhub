package com.alura.forumhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@Entity(name = "Perfil")
@Table(name = "perfis")
public class Perfil {
    @Id
    @Column(name = "perfil_id")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;

    @Column(name = "nome")
    @NotNull
    private String nome;
}
