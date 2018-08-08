# CaseTecnico-BackEndSpring

Este projeto foi gerado com Java 1.8 e Spring Tool Suit Version: 3.9.3.

# Instruções para o Build

Após fazer o clone do projeto execute os seguintes passos: 

1 - No arquivo application.properties localizado em src/main/resources/ altere o login e senha do banco de dados. 

2 - No momento do build será criado automáticamente um banco de dados mysql, chamado casetecnicodb.

3 - Execute o comando mvn clean install.

4 - Após a mensagem de build success do maven, verificar as tabelas do autor e Livro. 

execute os seguintes comandos para verificar os valores inseridos pelo teste unitário.

use casetecnicodb;

select * from autor;

select * from livro;

select * from comentario;

# As URLs do sistema são:

http://localhost:8080/autores

http://localhost:8080/livros

