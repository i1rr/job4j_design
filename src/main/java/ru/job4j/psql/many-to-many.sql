create table vehicle(
	id serial primary key,
	type varchar(20)
);

create table brand(
	id serial primary key,
	name varchar (50)
);

create table vehicle_brand(
	id serial primary key,
	vehicle_id int references vehicle(id),
	brand_id int references brand(id)
);

insert into vehicle(type) values ('Car');
insert into vehicle(type) values ('Motorcycle');
insert into vehicle(type) values ('Boat');

insert into brand(name) values ('Toyota');
insert into brand(name) values ('Honda');
insert into brand(name) values ('Suzuki');

insert into vehicle_brand(vehicle_id, brand_id) values (1, 1);
insert into vehicle_brand(vehicle_id, brand_id) values (1, 2);
insert into vehicle_brand(vehicle_id, brand_id) values (1, 3);
insert into vehicle_brand(vehicle_id, brand_id) values (2, 2);
insert into vehicle_brand(vehicle_id, brand_id) values (2, 3);
insert into vehicle_brand(vehicle_id, brand_id) values (3, 2);


