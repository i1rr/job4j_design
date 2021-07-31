create table race(
	id serial primary key,
	name varchar(100)
);

create table participants(
	id serial primary key,
	name varchar(50),
	race_id int references race(id)
);

insert into race(name) values ('MOTO-GP');
insert into participants(name, race_id) VALUES ('Valentino Rossi', 1);

select * from participants;
select * from race where id in (1);