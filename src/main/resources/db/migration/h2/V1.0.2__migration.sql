drop table if exists siblings CASCADE;

create table siblings (
                          id bigint generated by default as identity,
                          crianca_id bigint,
                          primary key (id)
);


insert into siblings(id, crianca_id)
values(1,1);
insert into siblings(id, crianca_id)
values(2,2);
insert into siblings(id, crianca_id)
values(3,3);