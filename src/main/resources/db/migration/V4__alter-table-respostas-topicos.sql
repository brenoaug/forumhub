ALTER TABLE respostas
    ADD usuario_id BINARY(16) NULL;

ALTER TABLE respostas
    MODIFY usuario_id BINARY(16) NOT NULL;

ALTER TABLE topicos
    ADD usuario_id BINARY(16) NULL;

ALTER TABLE topicos
    MODIFY usuario_id BINARY(16) NOT NULL;

ALTER TABLE respostas
    ADD CONSTRAINT FK_RESPOSTAS_ON_USUARIO FOREIGN KEY (usuario_id) REFERENCES usuarios (usuario_id);

ALTER TABLE topicos
    ADD CONSTRAINT FK_TOPICOS_ON_USUARIO FOREIGN KEY (usuario_id) REFERENCES usuarios (usuario_id);

ALTER TABLE respostas
    DROP COLUMN autor;

ALTER TABLE topicos
    DROP COLUMN autor;

ALTER TABLE topicos
    DROP COLUMN respostas;