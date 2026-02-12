CREATE TABLE usuarios
(
    usuario_id BINARY(16)   NOT NULL,
    nome       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL UNIQUE,
    senha      VARCHAR(255) NULL,
    CONSTRAINT pk_usuarios PRIMARY KEY (usuario_id)
);