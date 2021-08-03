create table role (
	id serial primary key,
	rolename varchar(30)
);

create table users (
	id serial primary key,
	firstname varchar(20),
	lastname varchar(25),
	role_id int references role(id)
);
	
create table rules (
	id serial primary key,
	rule text
);
	
create table role_rules (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table category (
	id serial primary key,
	catname varchar(20)
);

create table state (
	id serial primary key,
	statename varchar(20)
);

create table item (
	id serial primary key,
	itemname varchar(20),
	users_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table comments (
	id serial primary key,
	comment text,
	item_id int references item(id)
);

create table attachments (
	id serial primary key,
	attachment bytea,
	item_id int references item(id)
);