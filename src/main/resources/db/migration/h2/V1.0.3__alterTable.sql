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