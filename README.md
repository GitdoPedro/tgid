# TESTE DESENVOLVEDOR JR - TGID

## Descrição  
O teste consiste na criação de um app que monitora as transações envolvendo clientes e empresas. Todos os requisitos do sistema estão disponíveis no pdf presente neste repositório.


## Motivação
O projeto é uma aplicação transações bancárias, que oferece funcionalidades como saques, depósito e consulta de informações sobre clientes, empresas e as operações em si.
Ele utiliza controllers para lidar com as operações e serviços para executar a lógica de negócio.
Através de uma API, os usuários podem acessar essas funcionalidades, respeitando o padrão MVC.


## Tecnologias
Spring Boot: O projeto utiliza o framework Spring Boot como base, conforme especificado no elemento <parent>. O Spring Boot é um framework Java para criação de aplicativos e serviços robustos e escaláveis.

Spring Boot Starter: São utilizados diferentes starters do Spring Boot para facilitar a configuração e o uso de recursos específicos.
As dependências incluem spring-boot-starter-data-jpa para acesso a dados com JPA, spring-boot-starter-validation para validação de dados, spring-boot-starter-web para desenvolvimento de aplicativos web, e spring-boot-starter-test para testes.

Hibernate: O projeto utiliza o Hibernate como implementação do JPA (Java Persistence API).
O Hibernate é um framework de mapeamento objeto-relacional que permite o acesso e manipulação de dados em bancos de dados relacionais.

H2 Database: O projeto utiliza o H2 Database como uma dependência de tempo de execução, que é um banco de dados relacional em memória.
O H2 Database é amplamente utilizado para desenvolvimento e teste de aplicativos.

Essas tecnologias foram escolhidas para facilitar o desenvolvimento do projeto, fornecer recursos como acesso a dados, validação, mapeamento de objetos e simplificação do código.
O Spring Boot é o framework principal que integra essas tecnologias e permite a criação de uma aplicação eficiente e escalável.

## Possíveis Melhorias
* Adição de recursos de autenticação e autorização, para garantir a segurança e o controle de acesso ao sistema.
* Implantação de um sistema de backup e recuperação de dados, para evitar perda de informações e garantir a disponibilidade do sistema.
* Implementação de logs adequados na aplicação, registrando eventos relevantes e informações úteis para fins de depuração, monitoramento e análise de desempenho.
* Implementação de estruras de DTO, afim de isolar os modelos de banco de dados e melhorar o desacoplamento.  
  


   Desenvolvido por:
   Pedro Lima do Nascimento
   <a href="https://www.linkedin.com/in/pedro-lima-12b92332/">Linkedin | <a href="https://github.com/GitdoPedro">Github
