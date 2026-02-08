ALTER TABLE usuarios_perfis
    DROP FOREIGN KEY fk_usuper_on_perfil;

ALTER TABLE usuarios_perfis
    ADD CONSTRAINT FK_USUARIOS_PERFIS_ON_PERFIL FOREIGN KEY (perfil_id) REFERENCES perfis (perfil_id);

ALTER TABLE usuarios_perfis
    DROP FOREIGN KEY fk_usuper_on_usuario;

ALTER TABLE usuarios_perfis
    ADD CONSTRAINT FK_USUARIOS_PERFIS_ON_USUARIO FOREIGN KEY (usuario_id) REFERENCES usuarios (usuario_id);

