create table departments (
	id serial primary key,
	name varchar(50)
);


create table emploees (
	id serial primary key,
	name varchar(50),
	departments_id int references departments(id)
);

insert into departments (name) values
	('IT'),
	('Marketing'),
	('Sales'),
	('Accounting'),
	('B2B'),
	('B2C'),
	('Business Solutions'),
	('Events Management');

insert into emploees (name, departments_id) values
	('Ivan', 1),
	('Alex', 1),
	('Boris', 3),
	('Ahmed', 4),
	('Ismail', 6),
	('Uri', 8),
	('Toomas', 8);

select * from departments as d left join emploees as e on e.departments_id = d.id;
select * from departments as d right join emploees as e on e.departments_id = d.id;
select * from departments as d full join emploees as e on e.departments_id = d.id;

select * from departments as d 
left join emploees as e 
on e.departments_id = d.id
where e.departments_id is null;

select * from departments as d left join emploees as e on e.departments_id = d.id;
select * from emploees as e right join departments as d on e.departments_id = d.id;


create table teens (
	id serial primary key,
	name varchar(30),
	gender varchar(10)
);

insert into teens(name, gender) values
	('Vasja', 'm'),
	('Alex', 'w'),
	('Kolja', 'orc');

select t1.name, t2.gender
from teens t1 
cross join teens t2
where t1.gender != t2.gender;