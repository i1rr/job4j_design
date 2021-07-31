create table users (
id serial primary key,
first_name varchar(15),
last_name text,
	age int
);

insert into users(first_name, last_name, age) values('John', 'Smith', 35);

update users set first_name = 'Craig', last_name = 'Johnson', age = 42;

delete from users;