
--Script para popular tabela de permissao
INSERT INTO `tb_permission` (`pk_id`, `role`) VALUES (1,'ROLE_ADMIN');
INSERT INTO `tb_permission` (`pk_id`, `role`) VALUES (2,'ROLE_USER');
INSERT INTO `tb_permission` (`pk_id`, `role`) VALUES (3,'ROLE_FORNEC');

--Script para popular tabela de state
INSERT INTO `tb_state`(`id`,`name`,`symbol`) VALUES (1,'MINAS GERAIS','MG');
INSERT INTO `tb_state`(`id`,`name`,`symbol`) VALUES (2,'SÃO PAULO','SP');

--Script para popular tabela de state
INSERT INTO `tb_city`(`id`,`name`,`state_id`) VALUES (1,'Uberlândia',1);

--Script para popular tabela de neighborhood
INSERT INTO `tb_neighborhood`(`id`,`name`,`cuty_id`) VALUES (1,'JARDIM EUROPA',1);

--Script para popular tabela de address
INSERT INTO `tb_address`(`id`,`name`,`cep`,`district_id`) VALUES (1,'Rua Iolanda Alves Figueira','38414650',1);

--Script para popular tabela de usuario
INSERT INTO `tb_user` (`pk_id`,`name`, `email`, `password`,`phone`,`photo`,`address_id`,`address_complement`,`address_number`,`address_reference`,`last_name`) VALUES (1,'User 1','wannisson@gmail.com','123','34991393623',null,1,'casa','68','Perto do sesc senat','Freitas Pinho');
INSERT INTO `tb_user` (`pk_id`,`name`, `email`, `password`,`phone`,`photo`,`address_id`,`address_complement`,`address_number`,`address_reference`,`last_name`) VALUES (2,'User 2','wannisson.freitas.pinho@everis.com','123','34991393623',null,1,'casa','68','Perto do sesc senat','Freitas Pinho');

--Script para pupular a table de Permission x Usuario
INSERT INTO `tb_user_permission` (`permission_id`,`user_id`) VALUES (1,1);
INSERT INTO `tb_user_permission` (`permission_id`,`user_id`) VALUES (2,2);

--Script para pupular a table de product Category
INSERT INTO `tb_product_category`(`id`,`name`) VALUES (1,'Eletronicos');

--Script para pupular a table de product
INSERT INTO `tb_product`(`id`, `name`, `description`, `product_category`) VALUES (1, 'Galaxy j5', 'bom celular',1);

--Script para pupular a table de product request
INSERT INTO `tb_product_request`(`id`, `product_id`, `user_id`, `detail`, `delivery`, `request`) VALUES (1, 1, 1, 'detalhe do request do pedido', '2017-06-09', '2017-06-09');

--Script para pupular a table de supplier
INSERT INTO `tb_supplier`(`id`, `name`, `description`, `register_date`)	VALUES (1, 'fornecedor 1', 'Fornecedor', '2017-06-09');
