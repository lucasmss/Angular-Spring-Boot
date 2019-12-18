CREATE TABLE lancamento(
	codigo bigint(20) primary key auto_increment,
    descricao varchar(50) not null,
    data_vencimento date not null,
    data_pagamento date,
    valor decimal(10,2) not null,
    observacao varchar(100),
    tipo varchar(20) not null,
    codigo_categoria bigint(20) not null,
    codigo_pessoa bigint(20) not null,
    FOREIGN KEY (codigo_categoria) references categoria(codigo),
	FOREIGN KEY (codigo_pessoa) references pessoa(codigo)
);

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Salario', '2019-06-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 2, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Supermercado', '2019-02-10', '2019-02-10', 100.32, null, 'DESPESA', 3, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Supermercado', '2019-02-10', '2019-02-10', 110.44, null, 'DESPESA', 3, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Salario', '2019-06-10', null, 200.30, null, 'RECEITA', 3, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Alimentação', '2019-03-10', '2019-03-10', 1010.32, null, 'DESPESA', 2, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Alimentação', '2019-06-10', null, 500, null, 'RECEITA', 2, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Investimento Financeiro', '2019-03-10', '2019-03-10', 400.32, null, 'RECEITA', 5, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Supermercado', '2019-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Alimentação', '2019-04-10', '2019-04-10', 665.33, null, 'DESPESA', 2, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Farmácia', '2019-06-10', null, 8.32, null, 'DESPESA', 4, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Farmácia', '2019-04-10', '2019-04-10', 2100.32, null, 'DESPESA', 4, 1);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Salario', '2019-06-10', null, 1040.32, null, 'RECEITA', 4, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Farmácia', '2019-04-10', '2019-04-10', 4.32, null, 'DESPESA', 4, 2);
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Estudo Financeiro', '2019-06-10', null, 10.20, null, 'DESPESA', 5, 1);