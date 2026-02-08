CREATE TABLE topicos
(
    topico_id    BINARY(16)   NOT NULL,
    titulo       VARCHAR(255) NOT NULL,
    mensagem     VARCHAR(255) NOT NULL,
    data_criacao datetime     NULL,
    status       VARCHAR(255) NULL,
    autor        VARCHAR(255) NULL,
    curso        VARCHAR(255) NULL,
    respostas    VARCHAR(255) NULL,
    CONSTRAINT pk_topicos PRIMARY KEY (topico_id)
);