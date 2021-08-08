insert into people(name) values ('Alex');
insert into people(name) values ('Ivan');
insert into people(name) values ('Jimmy');

insert into devices(name, prices) values ('Dildo', 500);
insert into devices(name, prices) values ('Dick Ring', 250);
insert into devices(name, prices) values ('Condom', 100);

inser into devices_people(devices_id, people_id) values (1, 1);
inser into devices_people(devices_id, people_id) values (2, 1);
inser into devices_people(devices_id, people_id) values (3, 1);
inser into devices_people(devices_id, people_id) values (1, 2);
inser into devices_people(devices_id, people_id) values (2, 2);
inser into devices_people(devices_id, people_id) values (1, 2);
inser into devices_people(devices_id, people_id) values (3, 2);
inser into devices_people(devices_id, people_id) values (3, 2);
inser into devices_people(devices_id, people_id) values (3, 2);
inser into devices_people(devices_id, people_id) values (1, 3);

select avg(price) from devices;

select ppl.name, avg(dev.price)
from people as ppl
inner join devices_people as dp
on ppl.id = dp.people_id
inner join devices as dev
on dev.id = dp.devices_id 
group by ppl.name;

select ppl.name, avg(dev.price)
from people as ppl
inner join devices_people as dp
on ppl.id = dp.people_id
inner join devices as dev
on dev.id = dp.devices_id 
group by ppl.name
having avg(dev.price) > 5000;

















