create database test;
create table persons(
id int primary key auto_increment,
prenumele varchar(100),
varsta int,
adresa varchar(255),
salariu double
);

create table users(
id int primary key auto_increment,
email varchar(100),
password varchar(100)
);
drop table users;
select * from users;
select * from persons;
select * from persons where varsta=26;
delete from persons where id=17;