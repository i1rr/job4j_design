create table vehicle(
	id serial primary key,
	type varchar(20)
);

create table rego(
	id serial primary key,
	sn varchar (20),
	vin varchar (18)
);

create table vehicle_rego(
	id serial primary key,
	vehicles_id int references vehicles(id) unique,
	rego_id int references rego(id) unique
);

insert into vehicle(type) values ('Car');

insert into rego(sn, vin) values ('23uh5i34h', '43265hb435hb43');

insert into vehicle_rego(vehicle_id, rego_id) values (1, 1);