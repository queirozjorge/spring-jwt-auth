# spring-jwt-auth

Este é um repositório que tem por objetivo apenas demonstrar uma implementação de autenticação web utilizando Spring Security e jwt token.
Para rodar o projeto é necessário:
  - Realizar o clone do repositório,
  - Abrir o projeto na sua ide e configurar a jdk 20
  - Baixar as dependências através do comando Maven Install
  - E no postman, importar a collection e enviroments presentes na pasta src/main/java/br/com/jorge/springjwtauth/docs que está no projeto

Através dos endpoints /auth/register e /auth/signin é possível criar um novo usuário e se autenticar.
Para visualizar o cadastro de todos os usuários você pode acessar o endpoint /auth/users.
Para acessar o endpoint /api/get é necessário ser um usuário com role ADMIN.

Obs.: 
  - Já existe um usuário com permissão ADMIN salvo em memória: login: admin e senha: admin
  - Todos os usuários novos serão salvos somente em memória, pois o propósito desta aplicação não inclui conexão com banco de dados.
