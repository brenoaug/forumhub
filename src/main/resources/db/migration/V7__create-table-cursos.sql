CREATE TABLE cursos
(
    curso_id  BINARY(16)   NOT NULL,
    nome      VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NULL,
    CONSTRAINT pk_cursos PRIMARY KEY (curso_id)
);