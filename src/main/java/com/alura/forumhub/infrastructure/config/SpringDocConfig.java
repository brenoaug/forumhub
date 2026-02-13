package com.alura.forumhub.infrastructure.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Servidor de Desenvolvimento")
                ))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Insira o token JWT obtido no endpoint /login. Formato: Bearer {token}")))
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"))
                .info(new Info()
                        .title("ForumHub API")
                        .version("v1.0.0")
                        .description("""
                                ## Sobre o Projeto
                                
                                ForumHub é uma aplicação completa para gerenciamento de tópicos de fórum com autenticação JWT.
                                
                                ## Autenticação
                                
                                Esta API utiliza **JWT (JSON Web Token)** para autenticação. Siga os passos abaixo:
                                
                                1. **Faça login** usando o endpoint `POST /login` com suas credenciais
                                2. **Copie o token** JWT retornado na resposta
                                3. **Clique no botão Authorize** no topo desta página
                                4. **Cole o token** no campo de texto (não precisa adicionar "Bearer", será adicionado automaticamente)
                                5. Clique em **Authorize** e pronto!
                                
                                Agora você pode testar todos os endpoints protegidos.
                                
                                ## Funcionalidades
                                
                                - Criar novos tópicos com validação de duplicidade
                                - Listar tópicos com paginação e ordenação
                                - Buscar tópicos por curso e/ou ano
                                - Detalhar tópico específico
                                - Atualizar informações de tópicos
                                - Deletar tópicos
                                
                                
                                ##️ Tecnologias
                                
                                - Java 21
                                - Spring Boot 4.0.2
                                - Spring Security com JWT
                                - MySQL + Flyway
                                - SpringDoc OpenAPI
                                
                                ---
                                
                                **Desenvolvido por:** Breno Augusto
                                """)
                        .contact(new Contact()
                                .name("Breno Augusto")
                                .email("breaugustocp@outlook.com")
                                .url("https://github.com/brenoaug"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://github.com/brenoaug/forumhub?tab=MIT-1-ov-file")));
    }
}