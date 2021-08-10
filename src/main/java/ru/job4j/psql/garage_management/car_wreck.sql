-- Vehicle body
create table body (
	id serial primary key,
	color varchar(30)
);

-- Vehicle engine
create table engine (
	id serial primary key,
	volume varchar (20)
);

-- Vehicle gearbox
create table gearbox (
	id serial primary key,
	type varchar(10)
);

-- Vehicle itself
create table vehicle (
	id serial primary key,
	name varchar(50),
	body_id int references body(id),
	engine_id int references engine(id),
	gearbox_id int references gearbox(id)
);

-- Inserting 5 vehicle bodies
insert into body (color) values
	('Marble white'),
	('Imola Red'),
	('Yellow'),
	('Golden'),
	('Black');
	
-- Inserting 5 car engines	
insert into engine (volume) values
	('4.5L v8'),
	('4.4L v8'),
	('1.3L v4'),
	('2.0L v4'),
	('3.0L v6');

-- Inserting 5 car gearboxes
insert into gearbox (type) values
	('6s Auto'),
	('8s Auto'),
	('4s Manual'),
	('5s Auto'),
	('7s Auto');
	
-- Inserting 3 cars
insert into vehicle (name, body_id, engine_id, gearbox_id) values 
	('Toyota Land Cruiser', 1, 1, 1),
	('BMW X6', 2, 2, 2),
	('VAZ 2109', 3, 3, 3);
	
-- 1) Вывести список всех машин и все привязанные к ним детали
select v.name as Car, b.color as Color, e.volume as Engine, g.type as Gearbox
from vehicle as v, body as b, engine as e, gearbox as g
where b.id = v.body_id
and e.id = v.engine_id
and g.id = v.gearbox_id;

-- 2) Вывести отдельно детали, которые не используются НИ в одной машине, кузова, двигатели, коробки передач.
select b.color as "Stock body"
from vehicle as v
right join body as b
on b.id = v.body_id
where v.body_id is null;

select e.volume as "Stock engine"
from vehicle as v
right join engine as e
on e.id = v.engine_id
where v.engine_id is null;

select g.type as "Stock transmission"
from vehicle as v
right join gearbox as g
on g.id = v.gearbox_id
where v.gearbox_id is null;