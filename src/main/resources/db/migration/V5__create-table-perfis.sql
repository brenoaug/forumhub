CREATE TABLE perfis
(
    perfil_id BINARY(16)   NOT NULL,
    nome      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_perfis PRIMARY KEY (perfil_id)
);