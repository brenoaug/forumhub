package com.alura.forumhub.repository;

import com.alura.forumhub.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicoRepository extends JpaRepository<Topico, UUID> {
}
