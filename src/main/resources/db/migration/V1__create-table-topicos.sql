create table topicos (
    id varchar(36) primary key auto_increment,
    titulo varchar(255) not null,
    mensagem text not null,
    data_criacao timestamp not null default current_timestamp,
    status varchar(20) not null,
    autor varchar(255) not null,
    curso varchar(255) not null,
    resposta text
)