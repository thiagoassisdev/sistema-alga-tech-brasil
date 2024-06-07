# sistema-alga-tech-brasil
A AlgaTech Brasil é uma plataforma de gestão de fazenda de algas, focada no cultivo da alga chifre de veado (Asparagopsis taxiformis).


####AlgaTech Brasil
Descrição do Projeto
A AlgaTech Brasil é uma plataforma de gestão de fazenda de algas, focada no cultivo da alga chifre de veado (Asparagopsis taxiformis). Este sistema web responsivo permite o monitoramento e a gestão das operações da fazenda de algas, utilizando tecnologias avançadas para modernizar e tornar mais eficiente o processo de cultivo, contribuindo para a sustentabilidade e a redução do efeito estufa.

##Tecnologias Utilizadas

Front-end: React.js
Back-end: Java
Banco de Dados: Oracle SQL

##Funcionalidades

Dashboard de Monitoramento: Exibição em tempo real de dados sobre o cultivo das algas, incluindo temperatura, pH, salinidade e níveis de nutrientes.
Gestão de Colheita: Planejamento e registro das colheitas, com histórico de produção.
Controle de Qualidade: Módulo para análise da qualidade das algas, com integração de sensores IoT para coleta de dados.

##Objetivos do Projeto

A AlgaTech Brasil visa modernizar a plantação de algas utilizando tecnologias avançadas, tornando o processo mais eficiente e sustentável. Além disso, a plataforma se concentra no cultivo da alga chifre de veado, que possui uma alta taxa de sequestro de carbono e pode reduzir significativamente a emissão de metano quando consumida por ruminantes.

###Banco de Dados

#Resumo Técnico
O banco de dados foi projetado para gerenciar informações de fazendas, sensores, medições, colheitas e qualidade da água. As tabelas principais são:

FAZENDA: Armazena informações sobre as fazendas.
SENSOR: Armazena informações sobre os sensores utilizados para medições.
MEDICAO: Relacionada com FAZENDA e SENSOR através das chaves estrangeiras ID_FAZENDA e ID_SENSOR.
COLHEITA: Relacionada com FAZENDA através da chave estrangeira ID_FAZENDA.
QUALIDADE: Relacionada com FAZENDA através da chave estrangeira ID_FAZENDA.
Relacionamentos
FAZENDA: Tabela principal que armazena informações sobre as fazendas.
MEDICAO: Relacionada com FAZENDA através da chave estrangeira ID_FAZENDA. Cada medição está associada a uma fazenda específica.
COLHEITA: Relacionada com FAZENDA através da chave estrangeira ID_FAZENDA. Cada colheita está associada a uma fazenda específica.
QUALIDADE: Relacionada com FAZENDA através da chave estrangeira ID_FAZENDA. Cada registro de qualidade está associado a uma fazenda específica.
SENSOR: Relacionada com MEDICAO através da chave estrangeira ID_SENSOR. Cada medição está associada a um sensor específico.
