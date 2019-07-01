create database gotomovie;

use gotomovie;

create table actors ( 
	id int auto_increment,
	name varchar(30),
	lastName varchar(35),
	constraint pk_actors primary key(id)
);

create table users(
	id int auto_increment,
	name varchar(50),
	lastName varchar(50),
	userName varchar(25),
	password varchar(15),
	constraint pk_users primary key(id),
	constraint unq_userName UNIQUE(userName)
);

create table comments(
    id int auto_increment,
    comment varchar(450),
    userId int,
    movieId int,
    constraint pk_comment primary key(id)
)
-- agregar los constraint fk de user id y movie id