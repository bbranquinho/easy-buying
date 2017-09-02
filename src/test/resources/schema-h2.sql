drop table if exists public.tb_user;
drop table if exists public.tb_permission;
drop table if exists public.tb_user_permission;

create table tb_permission (
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
