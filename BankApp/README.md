# Bank REST API

REST API de um banco que realiza operações nas contas dentro de um database

## Requisitos do sistema

* JDK 11
* Apache Tomcat 9
* Maven
* Spring 5.2
* Jackson Json 2.10
* Junit 5
* Mockito 3.2
* Hibernate 6
* MySQL 8

## Modo de uso:

### - Database

* Executar a query user.sql dentro da conexão localhost (query se encontra na pasta SQLQuery)
* Criar uma conexão no MySQL Worckbench com nome "hbadmin"
* Executar a query bankdb.sql

### - Java Project

* Conectar com tomcat
* Run As: Run on Server


## Melhorias

* Implementação do Front End para consumir a API
* Implementação do Spring Security para as permissões de uso dos endpoints
* Testes de integração com API e com banco de dados
* Usar Spring Boot
* Uso de builders para as classes nos testes
* Código verboso, refatorar para ser mais "spring"
* Uso de ResponseEntity para tratar as chamadas HTTP
* Mais testes

## Destaques

* Organização do código
* Tratamento de exceções customizadas
* Persistência de dados
* 

## Dificuldades

A maior dificuldade foi no uso do Spring, pois por não conhecer o framework muito bem, passei bastante tempo aprendendo as suas funcionalidades.