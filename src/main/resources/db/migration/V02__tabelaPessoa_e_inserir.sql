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