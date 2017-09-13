
--Script para popular tabela de permissao
INSERT INTO `tb_permission` (`pk_id`, `role`) VALUES (1,'ROLE_ADMIN');
INSERT INTO `tb_permission` (`pk_id`, `role`) VALUES (2,'ROLE_USER');
INSERT INTO `tb_permission` (`pk_id`, `role`) VALUES (3,'ROLE_FORNEC');

--Script para popular tabela de usuario
INSERT INTO `tb_user` (`pk_id`,`name`, `email`, `password`,`phone`) VALUES (1,'User 1','wannisson@gmail.com','123','34991393623');
INSERT INTO `tb_user` (`pk_id`,`name`, `email`, `password`,`phone`) VALUES (2,'User 2','wannisson.freitas.pinho@everis.com','123','34991393623');

--Script para pupular a table de Permission x Usuario
INSERT INTO `tb_user_permission` (`permission_id`,`user_id`) VALUES (1,1);
INSERT INTO `tb_user_permission` (`permission_id`,`user_id`) VALUES (2,2);

INSERT INTO `tb_person`	VALUES (2,2,'Jardim Europa',38414650,'Uberlândia','MG','Rua Iolanda Alves Figueira',68,'Ativo',2);

INSERT INTO `tb_client` VALUES(2);