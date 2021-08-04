create table building(
	id serial primary key,
	type varchar(20)
);

create table location(
	id serial primary key,
	address varchar(50),
	building_id int references building(id)
);

insert into building (type) values ('school');
insert into building (type) values ('mall');
insert into building (type) values ('PD');

insert into location (address, building_id) values ('7 West rd.', 1);
insert into location (address, building_id) values ('109 Princess highway', 1);
insert into location (address, building_id) values ('Maria ave.', 1);

insert into location (address, building_id) values ('22 Mons rd.', 2);
insert into location (address, building_id) values ('133 Parker st.', 2);

insert into location (address, building_id) values ('56 Broom st.', 3);
insert into location (address, building_id) values ('12 Kaput ave.', 3);

insert into location (address) values ('44 Margaret st.');
insert into location (address) values ('77 Scott st.');

select * from location join building bld on location.building_id = bld.id;

select 
loc.address, bld.type 
from 
location as loc 
join 
building as bld 
on
loc.building_id = bld.id;

select
loc.address as Street, bld.type as Name
from
location as loc
join
building as bld
on
loc.building_id = bld.id;













