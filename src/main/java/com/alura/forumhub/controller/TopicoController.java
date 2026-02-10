package com.alura.forumhub.controller;

import com.alura.forumhub.dto.DadosCadastradosTopico;
import com.alura.forumhub.dto.DadosCriacaoTopico;
import com.alura.forumhub.entity.Topico;
import com.alura.forumhub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/criar-topico")
    public ResponseEntity<Object> criarTopico(@RequestBody @Valid DadosCriacaoTopico dadosCriacaoTopico,
                                                              UriComponentsBuilder uriComponentsBuilder) {
        if (repository.existsByTitulo(dadosCriacaoTopico.titulo())||repository.existsByMensagem(dadosCriacaoTopico.mensagem())) {
            return ResponseEntity.badRequest().body("Já existe um tópico com esse título e/ou mensagem.");
        }

        var topico = new Topico(dadosCriacaoTopico);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosCadastradosTopico(topico));
    }
}
