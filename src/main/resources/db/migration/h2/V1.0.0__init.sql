drop table if exists adocao CASCADE
drop table if exists crianca CASCADE
drop table if exists duvida CASCADE
drop table if exists siblings CASCADE
drop table if exists usuario CASCADE

create table adocao (
                        id bigint generated by default as identity,
                        adocao_status integer,
                        crianca_id bigint,
                        usuario_id bigint,
                        primary key (id)
)
create table crianca (
                         id bigint generated by default as identity,
                         address varchar(255),
                         civil_id varchar(255),
                         name varchar(255),
                         adocao_status integer,
                         age varchar(255),
                         gender varchar(255),
                         siblings_id bigint,
                         primary key (id)
)
create table duvida (
                        id bigint generated by default as identity,
                        duvida varchar(255),
                        resposta varchar(255),
                        usuario_id bigint,
                        primary key (id)
)
create table siblings (
                          id bigint generated by default as identity,
                          crianca_id bigint,
                          primary key (id)
)
create table usuario (
                         id bigint generated by default as identity,
                         address varchar(255),
                         age integer,
                         civil_id varchar(255),
                         gender varchar(255),
                         name varchar(255),
                         active boolean,
                         cpf varchar(255),
                         email varchar(255),
                         password varchar(255),
                         role varchar(255),
                         primary key (id)
)


alter table adocao
    add constraint FKclk6kmiq4gu22pun7un8ex6ey
        foreign key (crianca_id)
            references crianca;

alter table adocao
    add constraint FKjn3l4l09ekl6lkc2uucd0dk72
        foreign key (usuario_id)
            references usuario;

alter table crianca
    add constraint FK1ekku6099ahilp3rnfkyctfcq
        foreign key (siblings_id)
            references siblings;

alter table duvida
    add constraint FK5w9q7ypqdko3om54lbxbr3ops
        foreign key (usuario_id)
            references usuario;

alter table siblings
    add constraint FKhe1k51tg3vn68gqul160i6tlv
        foreign key (crianca_id)
            references crianca;