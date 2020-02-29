--drop table if exists suppliers;
create table if not exists suppliers
(
    id   int     not null primary key AUTO_INCREMENT,
    name varchar not null
);
insert into "suppliers" ("name")
values ('Acme, Inc.');
--insert into suppliers
--values ('Acme, Inc.');
--insert into suppliers
--values (49, 'Superior Coffee', '1 Party Place', 'Mendocino', 'CA', '95460');
--insert into suppliers
--values (150, 'The High Ground', '100 Coffee Lane', 'Meadows', 'CA', '93966');
