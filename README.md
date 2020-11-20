# Mock API
![License](img/license.svg)
![Version](img/version.svg)
![Coverage](img/coverage.svg)
## Objetivo
Criar uma API para consulta de registros de transações. Essa API gera valores simulados de transações e retorna uma lista de transações com base nos parâmetros informados. Nessas consultas, são informados id, ano e mês.

## Conjunto de dados
O conjunto de dados utilizado para a realização das consultas consiste em:
 + id
 + ano
 + mês

## Resultado das consultas
O resultado das consultas é uma lista, contendo cada uma das transações referenciadas pelo conjunto de dados de requisição.
Os resultados seguem o seguinte formato:

    {
        "description": "testing application",
        "amount": 1543,
        "date": 1603929600000
    }
## Tecnologias utilizadas
A API utiliza as seguintes tecnologias:

 + Java 8
 + Spring Boot 2.3.7
 + Gradle 6.7.1
 + JUnit
 + Swagger 2
 + Docker
 + Github
 + JetBrains IntelliJ IDEA Ultimate

## Como utilizar
Para executar a API:
 + Utilizar ferramenta como Postman ou similar para fazer as requisições para a API

`<Link>: <API_URL>`

A API desenvolvida não utiliza nenhum banco de dados para armazenamento, em memória, SQL ou NoSQL.
Dessa forma todas as consultas apresentam os resultados simulados em tempo real.

Os textos das descrições

Para maiores informações sobre endpoints, formatação das requisições, favor ler a documentação completa em:

`docs\DOCUMENTATION.md`
