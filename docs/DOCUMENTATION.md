# Documentação
## Instruções

### Como executar
A API pode ser executada utilizando Swagger ou realizando as requisições com Postman ou similares.
Para isso basta acessar a URI da API, conforme descrito no arquivo README.md.

### Endpoints 

#### Consultar transações

##### Método - GET

**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Consultar | _/mock/{id}/transacoes/{year}/{month}_ | GET

### Layout dos Payloads

#### Consultar transações
##### GET
    [
        {
            "description": "nificehota mewajebena",
            "amount": 150,
            "date": 1603929600000
        },
        {
            "description": "megibokake kichigaquapi",
            "amount": 63,
            "date": 1603238400000
        }
    ]
