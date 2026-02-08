CREATE TABLE usuarios_perfis
(
    perfil_id  BINARY(16) NOT NULL,
    usuario_id BINARY(16) NOT NULL
);

ALTER TABLE usuarios_perfis
    ADD CONSTRAINT fk_usuper_on_perfil FOREIGN KEY (perfil_id) REFERENCES perfis (perfil_id);

ALTER TABLE usuarios_perfis
    ADD CONSTRAINT fk_usuper_on_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios (usuario_id);

ALTER TABLE usuarios
    DROP COLUMN perfis;