package com.alura.forumhub.controller;

import com.alura.forumhub.dto.DadosAutenticacao;
import com.alura.forumhub.dto.DadosTokenJWT;
import com.alura.forumhub.entity.Usuario;
import com.alura.forumhub.infrastructure.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
        var authentication = authenticationManager.authenticate(token);

        var tokenJWT = tokenService.gerarToken((Usuario) Objects.requireNonNull(authentication.getPrincipal()));

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
