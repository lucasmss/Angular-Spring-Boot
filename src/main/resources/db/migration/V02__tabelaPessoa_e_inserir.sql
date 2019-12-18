CREATE TABLE pessoa(
	codigo bigint(20) primary key auto_increment,
    nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50),
	numero VARCHAR(10),
	complemento VARCHAR(50),
	bairro VARCHAR(20),
	cep VARCHAR(10),
    cidade VARCHAR(20),
    estado varchar(30),
    ativo boolean not null
);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
values ('Lucas Mateus', 'quadra 2', 'numero 18', 'apt 203', 'setor central', '70.561-250', 'Gama', 'DF', true);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
values ('Maria Eduarda', 'quadra 28', 'numero 8', 'casa 02', 'setor sul', '50.961-222', 'Gama', 'DF', true);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) 
values ('Eduarda', 'quadra 30', 'numero 10', 'casa 12', 'setor sul', '15.581-222', 'Gama', 'DF', false);