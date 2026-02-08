CREATE TABLE respostas
(
    resposta_id  BINARY(16)   NOT NULL,
    mensagem     VARCHAR(255) NOT NULL,
    topico_id    BINARY(16)   NOT NULL,
    data_criacao datetime     NULL,
    autor        VARCHAR(255) NULL,
    solucao      VARCHAR(255) NULL,
    CONSTRAINT pk_respostas PRIMARY KEY (resposta_id)
);

ALTER TABLE respostas
    ADD CONSTRAINT FK_RESPOSTAS_ON_TOPICO FOREIGN KEY (topico_id) REFERENCES topicos (topico_id);