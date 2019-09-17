CREATE TABLE pessoa(
	codigo bigint(20) primary key auto_increment,
    nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50),
	numero VARCHAR(10),
	complemento VARCHAR(50),
	bairro VARCHAR(20),
	cep VARCHAR(9),
    cidade VARCHAR(20),
    uf VARCHAR(2),
    ativo boolean
);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, uf, ativo) 
values ('Lucas Mateus', 'quadra 2', 'numero 18', 'apt 203', 'setor central', '705610', 'Gama', 'DF', true);

insert into pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, uf, ativo) 
values ('Selminha', 'quadra 9', 'numero 50', 'apt 502', 'Sul', '506369', 'Samanbaia', 'DF', true);