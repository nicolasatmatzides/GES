insert into usuario (id, address, age, civil_id, gender, name, active, cpf, email, password, role)
values(1,'rua exemplo', 23, '25696969', 'male', 'usuario Normal', '1', '0000000000', 'exemplo@gmail.com', '$2a$10$86ORR1UDP9neidEPmsHqUOxP9jaiL5CLjVZedkRgxto6tNfnBK0EO', 'ROLE_USER');
insert into usuario (id, address, age, civil_id, gender, name, active, cpf, email, password, role)
values(2,'rua exemplo', 23, '25696970', 'male', 'usuario admin  ', '1', '0000000001', 'admim@gmail.com', '$2a$10$86ORR1UDP9neidEPmsHqUOxP9jaiL5CLjVZedkRgxto6tNfnBK0EO', 'ROLE_ADMIN');

insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(1, 'rua da adoção', 11,'2020202020','MASCULINO','Claudio', 'COMPLETED');
insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(2, 'rua da adoção', 10,'20202021','FEMININO','Joana', 'COMPLETED');
insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(3, 'rua da adoção', 13,'80808416515','FEMININO','Raquel', 'COMPLETED');
insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(5, 'rua Z', 14,'15132150','MASCULINO','Rodrigo', 'EMPTY');
insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(6, 'rua Y', 9,'218044984','FEMININO','Juliana', 'EMPTY');
insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(7, 'rua X', 8,'808984','FEMININO','Leilane', 'EMPTY');
insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(8, 'rua X', 8,'808984','FEMININO','Júlia', 'IN_PROGRESS');
insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(9, 'rua X', 8,'808984','FEMININO','Laís', 'IN_PROGRESS');
insert into crianca  (id, address, age, civil_id, gender, name, adocao_status)
values(10, 'rua X', 8,'808984','FEMININO','Pedro', 'IN_PROGRESS');


insert into duvida (id, duvida, resposta, usuario_id)
values(1, 'essa é a minha duvida', 'essa é minha resposta', 1);
insert into duvida (id, duvida, resposta, usuario_id)
values(2, 'essa é a minha segunda duvida', 'essa é minha segunda resposta', 1);
insert into duvida (id, duvida, resposta, usuario_id)
values(3, 'essa é a minha terceira duvida', 'essa é minha segunda resposta', 1);
insert into duvida (id, duvida, resposta, usuario_id)
values(4, 'essa é a minha quarta duvida', 'essa é minha segunda resposta', 1);
insert into duvida (id, duvida, resposta, usuario_id)
values(5, 'essa é a minha quinta duvida', 'essa é minha segunda resposta', 1);
insert into duvida (id, duvida, resposta, usuario_id)
values(6, 'essa é a minha sexta duvida', 'essa é minha segunda resposta', 1);