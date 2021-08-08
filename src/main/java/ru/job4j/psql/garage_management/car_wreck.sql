-- Vehicle table
create table vehicle (
	id serial primary key,
	name varchar(50)
);

-- Vehicle body table
create table body (
	id serial primary key,
	color varchar(30),
	vehicle_id int references vehicle(id)
);

-- Vehicle engine table
create table engine (
	id serial primary key,
	volume varchar (20),
	vehicle_id int references vehicle(id)
);

-- Vehicle gearbox table
create table gearbox (
	id serial primary key,
	type varchar(10),
	vehicle_id int references vehicle(id)
);

-- Inserting 3 cars
insert into vehicle (name) values 
	('Toyota Land Cruiser'),
	('BMW X6'),
	('VAZ 2109');

-- Inserting 5 vehicle bodies
insert into body (color, vehicle_id) values
	('Marble white', 1),
	('Imola Red', 2),
	('Yellow', 3),
	('Golden', null),
	('Black', null);
	
-- Inserting 5 car engines	
insert into engine (volume, vehicle_id) values
	('4.5L v8', 1),
	('4.4L v8', 2),
	('1.3L v4', 3),
	('2.0L v4', null),
	('3.0L v6', null);

-- Inserting 5 car gearboxes
insert into gearbox (type, vehicle_id) values
	('6s Auto', 1),
	('8s Auto', 2),
	('4s Manual', 3),
	('5s Auto', null),
	('7s Auto', null);

-- 1) Вывести список всех машин и все привязанные к ним детали
select vehicle.name as Car, body.color as Color, engine.volume as Engine, gearbox.type as Gearbox
from vehicle, body, engine, gearbox
where (vehicle.id = gearbox.vehicle_id)
and (vehicle.id = body.vehicle_id)
and (vehicle.id = engine.vehicle_id);

-- 2) Вывести отдельно детали, которые не используются НИ в одной машине, кузова, двигатели, коробки передач.
select body.color as "body color"
from body
where (body.vehicle_id is null);

select engine.volume as "engine"
from engine
where (engine.vehicle_id is null);

select gearbox.type as "gearbox"
from gearbox
where (gearbox.vehicle_id is null);

