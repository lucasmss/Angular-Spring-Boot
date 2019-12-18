create table categoria(
	codigo bigint(20) primary key auto_increment,
    nome varchar(50)  not null
);

insert into categoria (nome) value("Lazer"); 
insert into categoria (nome) value("Alimentação"); 
insert into categoria (nome) value("Supermecado"); 
insert into categoria (nome) value("Farmácia"); 
insert into categoria (nome) value("Salario"); 
insert into categoria (nome) value("Estudos Finaceiro");  
insert into categoria (nome) value("Investimento Financeiro"); 