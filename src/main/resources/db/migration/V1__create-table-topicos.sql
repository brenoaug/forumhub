CREATE TABLE topicos
(
    topico_id    BINARY(16)   NOT NULL,
    titulo       VARCHAR(255) NOT NULL,
    mensagem     TEXT         NOT NULL,
    data_criacao datetime     NOT NULL,
    status       VARCHAR(255) NOT NULL,
    autor        VARCHAR(255) NOT NULL,
    curso        VARCHAR(255) NULL,
    CONSTRAINT pk_topicos PRIMARY KEY (topico_id)
);