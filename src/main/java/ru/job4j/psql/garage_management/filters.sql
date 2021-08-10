create table type (
	id serial primary key,
	name varchar(255)
);

create table product (
	id serial primary key,
	name varchar(255),
	expired_date date,
	price float,
	type_id int references type(id)
);

insert into type(name) values ('Сыр'), ('Молоко'), ('Алкоголь'), ('Мясо'), ('Овощи');

insert into product(name, expiry_date, price, type_id)
values
('Копченный', current_date + interval '1 month', 25, 1),
('Боккончини', current_date + interval '7 days', 10, 1),
('Моцарелла', current_date + interval '20 days', 12, 1),
('Сулугуни', current_date + interval '25 days', 40, 1),

('Свежее', current_date + interval '7 days', 4, 2),
('Обезжиренное', current_date + interval '7 days', 4.5, 2),
('Сгущённое', current_date + interval '1 month', 6, 2),
('Козье', current_date + interval '7 days', 8, 2),
('Сухое', current_date + interval '24 month', 10, 2),

('Whiskey', current_date + interval '12 months', 50, 3),
('Cognac', current_date + interval '12 months', 120, 3),
('Vodka', current_date + interval '12 months', 30, 3),
('Beer', current_date + interval '12 months', 5, 3),
('Tequila', current_date + interval '12 months', 55, 3),

('Говядина', current_date + interval '14 days', 30, 4),
('Свинина', current_date + interval '14 days', 25, 4),
('Курятина', current_date + interval '14 days', 15, 4),
('Телятина', current_date + interval '14 days', 28, 4),

('Огурцы', current_date + interval '10 days', 12, 5),
('Помидоры', current_date + interval '10 days', 10, 5),
('Морковь', current_date + interval '10 days', 2.5, 5),
('Свекла', current_date + interval '10 days', 5, 5),
('Кабачки', current_date + interval '10 days', 7, 5),
('Цуккини', current_date + interval '10 days', 8, 5),
('Баклажаны', current_date + interval '10 days', 9, 5);

/*  Написать запрос получение всех продуктов с типом "СЫР" */
select t.name as Тип, p.name as Продукт
from product as p, type as t
where t.id = p.type_id
and t.name = 'Сыр';

/*  Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое" */
select * from product where name like '%мороженое%';

/* Написать запрос, который выводит все продукты, срок годности которых уже истек */
select * from product where expiry_date < current_date;

/*  Написать запрос, который выводит самый дорогой продукт. */
select * from product where price = (select MAX(price) from product);

/*  Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество */
select t.name, count(p.type_id)
from product as p
inner join type as t
on p.type_id = t.id
group by t.name;

/*  Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО" */
select t.name as Тип, p.name as Продукт
from product as p, type as t
where t.id = p.type_id
and (t.name = 'Сыр' or t.name = 'Молоко');

/* Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук. */
Под количеством подразумевается количество продуктов определенного типа. 
Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла", 
которые ему принадлежат, то количество продуктов типа "СЫР" будет 2. 
select t.name, count(p.type_id)
from product as p
inner join type as t
on p.type_id = t.id
group by t.name
having count(p.type_id) < 10;

/* Вывести все продукты и их тип. */
select p.name, t.name
from product p
inner join type t
on p.type_id = t.id
group by p.name, t.name
order by t.name asc;