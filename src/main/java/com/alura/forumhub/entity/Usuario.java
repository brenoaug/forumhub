package com.alura.forumhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.UUID;

@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "senha")
    private String senha;
}
