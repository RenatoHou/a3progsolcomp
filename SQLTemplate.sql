CREATE DATABASE `project_java` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

create table cliente(
cpf integer not null,
nome varchar(50) not null,
idade integer,
constraint PK_cliente primary key(cpf)
);

create table compra(
nf integer not null auto_increment,
data_compra integer not null,
cpf_cliente integer not null,
constraint PK_compra primary key(nf)
);

create table produto(
artigo integer not null auto_increment,
preco double not null,
qtde_produto integer not null,
descricao varchar(100),
constraint PK_produto primary key(artigo)
);

create table venda_produto(
nf integer not null,
cod_produto integer not null,
qtde_vendida integer not null,
preco_venda double not null,
constraint PK_vendap primary key(nf, cod_produto)
);

