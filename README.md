Link para o Vídeo/Apresentação:
```bash
  https://drive.google.com/drive/folders/1bRFAHC-nAnh0uVJSj6cDVMf8ccUIoFvj
```

# Bookify


`Autores`

- 86062 - Leonardo Andrade Antunes de Bem

- 85521 - Martin david Valdes Olcese

- 82172 - Henrique Sartal Santos

- 85744 - João Carlos Melo Azevedo

- 84314 - Iago Manholetti Alexandrino

- 85569 - Gustavo Gonçalves de Araujo

- 84254 - José Dijalbas Francisco dos Santos Bezerra


## Objetivo
Não apenas, mas principalmente no contexto da pandemia, a falta de acesso a oportunidades de trabalho tornou a vida de muitas pessoas muito mais difícil. Com isso, o acesso à cultura, educação e informação tem se tornado difícil para a população pela falta de recursos.  

Nesse contexto, tendo em mente que no Brasil o privilégio de possuir um livro se limita a um nicho, tendo em vista os altos preços e as prioridades que acabam sendo colocadas em primeiro lugar nas contas das famílias brasileiras como aluguel e luz, o grupo CTT pensou em uma solução tecnológica e inovadora para espalhar e incentivar o hábito da leitura no país por meio do nosso projeto Bookify. 

O sistema Bookify, tem como finalidade o auxílio no cadastro e gestão de doações de livros entre pessoas físicas e empresas interessadas em participar do projeto. 





## Endpoints API

#### Gerenciar Livros

| Função | Endpoint    | Verbo                      | Método   |
| :- | :- | :- | :- |
| Listar todos os livros               | `api/book` | GET | `index()` |
| Exibir detalhes de um livro específico | `api/book/{id}` | GET | `get()` |
| Cadastrar um livro                     | `api/book` | POST | `create()` |
| Apagar um livro                        | `api/book/{id}` | DELETE | `delete()` |
| Alterar dados de livro                 | `api/book/{id}` | UPDATE | `update()` |

#### Gerenciar Usuários

| Função | Endpoint    | Verbo                      | Método   |
| :- | :- | :- | :- |
| Listar todos os usuários                 | `api/user` | GET | `index()` |
| Exibir detalhes de um usuário específico | `api/user/{id}` | GET | `get()` |
| Cadastrar um usuário                     | `api/user` | POST | `create()` |
| Apagar um usuário                        | `api/user/{id}` | DELETE | `delete()` |
| Alterar dados de usuário                 | `api/user/{id}` | UPDATE | `update()` |


  
## Funcionalidades do backend

- Cadastrar usuários
- Cadastrar livros
- Listar usuários
- Listar livros

` Os endpoints dão a possibilidade do gerenciamento total dos objetos`

## Arquitetura do projeto

- Aplicação Spring

- Thymeleaf

- Lombok

- BeanValidation

- Spring Boot Actuator

- Banco de Dados H2
## Iniciar o projeto

1- Clone o projeto.

```bash
  git clone https://github.com/henriquesart/ChallengeSprints_DBE_CTT.git
```
2 - Selecione o arquivo "DbeChallengeApplication.java" e rode como uma aplicação java.

3 - Entre no projeto via navegador pelo endereço "http://localhost:8080/"

  
