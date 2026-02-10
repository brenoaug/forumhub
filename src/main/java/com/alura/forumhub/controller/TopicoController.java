package com.alura.forumhub.controller;

import com.alura.forumhub.dto.DadosCadastradosTopico;
import com.alura.forumhub.dto.DadosCriacaoTopico;
import com.alura.forumhub.entity.Topico;
import com.alura.forumhub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;


@RestController
@RequestMapping("/topicos")
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/criar-topico")
    public ResponseEntity<Object> criarTopico(@RequestBody @Valid DadosCriacaoTopico dadosCriacaoTopico, UriComponentsBuilder uriComponentsBuilder) {
        if (repository.existsByTitulo(dadosCriacaoTopico.titulo()) || repository.existsByMensagem(dadosCriacaoTopico.mensagem())) {
            return ResponseEntity.badRequest().body(Map.of("mensagem","Já existe um tópico com esse título e/ou mensagem."));
        }

        var topico = new Topico(dadosCriacaoTopico);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosCadastradosTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosCadastradosTopico>> listarTopicos(@PageableDefault(sort = {"dataCriacao"}) Pageable pageable) {
        var topicos = repository.findAll(pageable);

        return ResponseEntity.ok().body(topicos.map(DadosCadastradosTopico::new));
    }
}
