drop table if exists public.tb_user;
drop table if exists public.tb_permission;
drop table if exists public.tb_user_permission;
drop table if exists public.tb_person;
drop table if exists public.tb_client;

create table public.tb_permission (
pk_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
role varchar(45)
);

create table public.tb_user (
  pk_id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name varchar(45),
  email varchar(255),
  password varchar(80),
  phone varchar(11)
);

create table public.tb_user_permission (
permission_id INT,
user_id INT,
FOREIGN KEY (permission_id) REFERENCES public.tb_permission(pk_id),
FOREIGN KEY (user_id) REFERENCES public.tb_user(pk_id)
);

create table public.tb_person (
  id_person int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  PERSON_TYPE int,
  bairro varchar(70),
  cep varchar(150),
  cidade varchar(70),
  estado varchar(50),
  rua varchar(150),
  numero varchar(20),
  status varchar(20),
  user_id int,
  FOREIGN KEY (user_id) REFERENCES public.tb_user(pk_id)
);


create table public.tb_client (
id_person int,
FOREIGN KEY (id_person) REFERENCES public.tb_person(id_person)
);



