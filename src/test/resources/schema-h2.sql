drop table if exists public.tb_user;
drop table if exists public.tb_permission;
drop table if exists public.tb_user_permission;
drop table if exists public.tb_person;
drop table if exists public.tb_client;
drop table if exists public.tb_state;
drop table if exists public.tb_city;
drop table if exists public.tb_neighborhood;
drop table if exists public.tb_address;
drop table if exists public.tb_product_category;
drop table if exists public.tb_product;
drop table if exists public.tb_product_request;
drop table if exists public.tb_supplier;

create table public.tb_permission (
pk_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
role varchar(45)
);

CREATE TABLE public.tb_state(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(127),
    symbol varchar(5)
);

CREATE TABLE public.tb_city(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(127),
    state_id int,
    FOREIGN KEY (state_id) REFERENCES public.tb_state(id)
);

CREATE TABLE public.tb_neighborhood(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(127),
    cuty_id int,
    FOREIGN KEY (cuty_id) REFERENCES public.tb_city(id)
);

CREATE TABLE public.tb_address(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(127),
    district_id int,
    cep varchar(8),
    FOREIGN KEY (district_id) REFERENCES public.tb_neighborhood(id)
);


create table public.tb_user (
  pk_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name varchar(45),
  email varchar(255),
  password varchar(80),
  phone varchar(20),
  address_id int,
  address_complement varchar(127),
  address_number varchar(20),
  address_reference varchar(127),
  last_name varchar(127),
  photo blob,
  FOREIGN KEY (address_id) REFERENCES public.tb_address(id)
);

create table public.tb_user_permission (
permission_id INT,
user_id INT,
FOREIGN KEY (permission_id) REFERENCES public.tb_permission(pk_id),
FOREIGN KEY (user_id) REFERENCES public.tb_user(pk_id)
);

CREATE TABLE public.tb_product_category(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(45)
);

CREATE TABLE public.tb_product
(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(127) NOT NULL,
    description varchar(255),
    product_category int NOT NULL,
   FOREIGN KEY (product_category) REFERENCES public.tb_product_category(id)
);

CREATE TABLE public.tb_product_request
(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    product_id int NOT NULL,
    user_id int NOT NULL,
    detail varchar(127)  NOT NULL,
    delivery date NOT NULL,
    request date NOT NULL,
  FOREIGN KEY (product_id) REFERENCES public.tb_product(id),
  FOREIGN KEY (user_id) REFERENCES public.tb_user(pk_id)

);

CREATE TABLE public.tb_supplier
(
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(127) NOT NULL,
    description varchar(127) NOT NULL,
    register_date date  NOT NULL,
    logo longblob
);






