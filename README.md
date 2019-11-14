# CRUD_SistemaProfessor_B-sico

- Sistema CRUD de professores web básico com apenas 2 campos:

-Incluir
-Alterar
-Excluir
-Listar

-Professor.java: É criado o objeto professor, com seus atributos e métodos de encapsulamento (Getters and Setters) e construtores.

-ProfessorDAO.java: É feita a abertura do banco para gravar os dados, e criado os métodos Incluir, Alterar, Excluir e Listar.

-ConnectionFactory: Classe onde é feita toda a conexão com o banco de dados.

-Servlets: Classes usadas para estender as funcionalidades do servidor (Tomcat), elas recebem a requisição, processa ou envia para outra classe processar e depois retorna uma resposta para onde precisar.

-Banco de dados utilizado: phpMyAdmin.

-Conexão: A conexão é feita pelo ConnectionFactory, onde é passado o caminho do Driver MySQL, a porta utilizada, e o nome do banco, junto com o usuário e senha para conexào.


