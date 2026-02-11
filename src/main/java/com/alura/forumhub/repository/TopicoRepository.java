package com.alura.forumhub.repository;

import com.alura.forumhub.entity.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TopicoRepository extends JpaRepository<Topico, UUID> {
    boolean existsByTitulo(String titulo);
    boolean existsByMensagem(String mensagem);

    Page<Topico> findByCursoContainingIgnoreCase(String curso, Pageable pageable);

    @Query(
            "SELECT t FROM Topico t WHERE YEAR(t.dataCriacao) = :ano"
    )
    Page<Topico> findByDataCriacaoYear(int ano, Pageable pageable);

    @Query(
        "SELECT t FROM Topico t WHERE (t.curso) LIKE LOWER(CONCAT('%', :cursoPesquisa, '%')) AND YEAR(t.dataCriacao) = :ano"
    )
    Page<Topico> findByCursoContainingIgnoreCaseAndDataCriacaoYear(String cursoPesquisa, int ano, Pageable pageable);

}
