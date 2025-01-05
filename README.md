<h1 align="center">Projeto MongoDB com Spring Boot</h1>

![Badge Concluído](https://img.shields.io/static/v1?label=Status&message=Concluido&color=gren&style=for-the-badge)
![Badge Java](https://img.shields.io/static/v1?label=Java&message=17&color=red&style=for-the-badge&logo=Java)
![Badge Spring](https://img.shields.io/static/v1?label=SpringBoot&message=v3.2.0&color=brightgreen&style=for-the-badge&logo=SpringBoot)
![Badge MongoDb](https://img.shields.io/static/v1?label=Mongo&message=V8.0&color=green&style=for-the-badge&logo=Mongodb)

## Resumo do projeto
#### Curso: Programação Orientada a Objetos com Java
#### http://educandoweb.com.br
#### Prof. Dr. Nelio Alves
- Compreender as principais diferenças entre paradigma orientado a documentos e relacional
- Implementar operações de CRUD
- Refletir sobre decisões de design para um banco de dados orientado a documentos
- Implementar associações entre objetos
  - Objetos aninhados
  - Referências
- Realizar consultas com Spring Data e MongoRepository

## Funcionalidades

### Usuario </br>
- `Cadastrar`: Cadastro de Usuarios através de um **POST /users** com as informações de *name* e *email* do
  usuario no corpo da requisição. Segue abaixo um exemplo do **corpo da requisição**.</br></br>

  ```[json
    {
      "name" : "Lorem Ipsum",
      "email" : "lorem@email.com"
    }
  ```

- `Atualizar`: Atualizar usuario através de um **PUT /users/{ID}**, onde *{ID}* é o identificador do usuario,
  os novos dados do usuario devem ser enviados no corpo da requisição. Segue abaixo um exemplo do **corpo da requisição**.</br></br>

  ```[json
    {
      "name" : "Lorem Ipsum",
      "email" : "lorem@email.com"
    }
  ```

- `Deletar`: Deletar usuario através de um **DELETE /users/{ID}**, onde *{ID}* é o identificador do usuario.</br></br>


- `Buscar por id`: Busca usuario por id através de um **GET /users/{ID}**, onde *{ID}* é o identificador do usuario.
  Segue abaixo um exemplo do **corpo da resposta**.</br></br>

  ```[json
    {
        "id": "6779cf8e2a6bfc616784c4df",
        "name": "Maria fazendeira",
        "email": "maria@email.com"
    }   
    ```
  

- `Buscar por todos os usuaios`: Busca através de um **GET /users**, .
  Segue abaixo um exemplo do **corpo da resposta**.</br></br>

  ```[json
         [
             {
                 "id": "6779cf8e2a6bfc616784c4df",
                 "name": "Maria fazendeira",
                 "email": "maria@email.com"
             },
             {
                 "id": "6779cf8e2a6bfc616784c4e0",
                 "name": "jose padeiro",
                 "email": "jose@email.com"
             },
             {
                 "id": "6779cf8e2a6bfc616784c4e1",
                 "name": "antonio leiteiro",
                 "email": "antonio@email.com"
            }
        ]
  ```
### Posts </br>
  - `Buscar por id`: Busca um post por id através de um **GET /post/{ID}**, onde *{ID}* é o identificador do post.
    Segue abaixo um exemplo do **corpo da resposta**.</br></br>

    ```[json
        {
        "id": "677a989fea0a620c5f0f8fa5",
        "date": "2018-03-23T00:00:00.000+00:00",
        "title": "Bom dia ",
        "body": "Acordei feliz hoje!",
         "author": {
            "id": "677a989fea0a620c5f0f8fa2",
            "name": "Maria fazendeira"
        },
        "comments": [
          {
            "text": "Aproveite",
            "date": "2018-03-22T00:00:00.000+00:00",
            "author": {
              "id": "677a989fea0a620c5f0f8fa3",
              "name": "jose padeiro"
            } 
          }
         ]
        } 
      ```
    - `Buscar por titulo`: Busca um post por palavras contidas no titulo através de um **GET /post/titlesearch?text=bom**.
      Segue abaixo um exemplo do **corpo da resposta**.</br></br>

    ```[json
        {
        "id": "677a989fea0a620c5f0f8fa5",
        "date": "2018-03-23T00:00:00.000+00:00",
        "title": "Bom dia ",
        "body": "Acordei feliz hoje!",
         "author": {
            "id": "677a989fea0a620c5f0f8fa2",
            "name": "Maria fazendeira"
        },
        "comments": [
          {
            "text": "Aproveite",
            "date": "2018-03-22T00:00:00.000+00:00",
            "author": {
              "id": "677a989fea0a620c5f0f8fa3",
              "name": "jose padeiro"
            } 
          }
         ]
        } 
      ```
    - `Buscar Completa`: Busca um post por palavras contidas no titulo, no corpo ou nos comentarios podendo ta,bem filtrar por datas minimas e maximas através de um **GET /post/fullsearch?text=viagem**.
      Segue abaixo um exemplo do **corpo da resposta**.</br></br>
````[json
    {
    "id": "677a989fea0a620c5f0f8fa6",
    "date": "2018-03-21T00:00:00.000+00:00",
    "title": "Partiu Viagem",
    "body": "Vou viajar para São Paulo. Abraços!",
    "author": {
      "id": "677a989fea0a620c5f0f8fa2",
      "name": "Maria fazendeira"
    },
    "comments": [
    {
      "text": "Boa Viagem mano!",
      "date": "2018-03-21T00:00:00.000+00:00",
      "author": {
        "id": "677a989fea0a620c5f0f8fa4",
        "name": "antonio leiteiro"
      }
    },
    {
      "text": "Tenha um otimo dia!",
      "date": "2018-03-23T00:00:00.000+00:00",
      "author": {
        "id": "677a989fea0a620c5f0f8fa4",
        "name": "antonio leiteiro"
           }
          }
        ]
      }
    ]
````
    Obs: esse endpoin pode ser usado **GET /post/fullsearch?text=viagem**, **GET /post/fullsearch?mindate=23-03-2018**, **GET /post/fullsearch?maxdate=23-03-2018** ou **GET /post/fullsearch?text=viagem&mindate=23-03-2018&maxdate=24-03-20218** o resultado sera o mesmo json acima.





## Criar container docker da aplicação

Execute este aquivo [docker-compose.yaml](https://github.com/jvictornascimento/workshop-spring-boot-mongodb/blob/master/docker-compose.yaml). 
Que irá subir um container com uma imagem do mongoDB mais a imagem do projeto.

  ```
    docker-compose -f docker-compose.yaml up
  ```

Após subir os containers, todas as funcionaliades acima estaram disponivel em  <http://localhost:8080>
## Tecnologias

- `Intellij`
- `Java 17`
- `Maven`
- `Spring Boot, Spring MVC, Spring Data JPA, Spring Mongo`
- `MongoDb`
- `Docker, Docker-hub`


