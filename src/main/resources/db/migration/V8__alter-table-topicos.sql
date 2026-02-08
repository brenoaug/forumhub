ALTER TABLE topicos
    ADD curso_id BINARY(16) NULL;

ALTER TABLE topicos
    ADD CONSTRAINT FK_TOPICOS_ON_CURSO FOREIGN KEY (curso_id) REFERENCES cursos (curso_id);

ALTER TABLE topicos
    DROP COLUMN curso;