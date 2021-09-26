# ENQUETE- Backend

<span class="colour" style="color: rgb(37, 37, 37);">Esta é a base de código para o backend da Enquete (Votação com estatísticas), um desafio de codificação fornecido para testar conhecimento.</span>
<br>
## Tecnologias utilizadas

* Java: 1.8
* Spring-boot: 2.3
* Maven: 3.6
* MySQL: 5.7

<br>
## Como utilizar:

* Configurar banco de dados:

```
//Acesse a pasta: apirest/src/main/resources
//no arquivo: application.properties
//altere as configurações: [seubancoaqui, usuario, senha] 

spring.datasource.url= jdbc:mysql://localhost:3306/seubancoaqui?useSSL=false&createDatabaseIfNotExist=true
spring.datasource.username= usuario
spring.datasource.password= senha
```

* Run dev server:

```
//na pasta raiz: apirest
mvn spring-boot:run
```
<br>
## Swagger UI

* Para acessar a documentação swagger: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Essa documentação apresenta todos os endpoints, com exemplos de json como devem ser representados na requisição, bem como o retorno de cada endpoint.

<br>
Obrigado pelo desafio.