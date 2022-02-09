ALTER TABLE crianca
    ADD siblings_id bigint;

alter table crianca
    add constraint FK5w9q7ypqdko3om54lbxbr3lps
        foreign key (siblings_id)
            references siblings;

UPDATE crianca
SET siblings_id = 1
WHERE id = 1;

UPDATE crianca
SET siblings_id = 2
WHERE id = 1;

UPDATE crianca
SET siblings_id = 3
WHERE id = 2;

insert into adocao (id, adocao_status, crianca_id, usuario_id)
values(1, 'COMPLETED', 1, 1);
