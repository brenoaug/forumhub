CREATE TABLE usuarios
(
    usuario_id BINARY(16)   NOT NULL,
    nome       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    senha      VARCHAR(255) NOT NULL,
    perfis     VARCHAR(255) NULL,
    CONSTRAINT pk_usuarios PRIMARY KEY (usuario_id)
);

ALTER TABLE usuarios
    ADD CONSTRAINT uc_usuarios_email UNIQUE (email);