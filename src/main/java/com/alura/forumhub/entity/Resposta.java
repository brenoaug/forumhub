package com.alura.forumhub.entity;

import com.alura.forumhub.entity.enums.SolucaoResposta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.alura.forumhub.entity.enums.SolucaoResposta.VERIFICANDO;

@Entity(name = "Resposta")
@Table(name = "respostas")
public class Resposta {
    @Id
    @Column(name = "resposta_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "mensagem")
    @NotNull
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    @NotNull
    private Topico topico;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "autor")
    private String autor;

    @Column(name = "solucao")
    @Enumerated(EnumType.STRING)
    private SolucaoResposta solucao = VERIFICANDO;

}
