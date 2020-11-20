# Documentação
## Instruções

### Como executar
A API pode ser executada utilizando Swagger ou realizando as requisições com Postman ou similares.
Para isso basta acessar a URL da API:

`<API_URL>`

Para acesso utilizando Swagger, basta acessar:

`<API_URL>/swagger-ui`

### Endpoints 

#### Consultar transações

##### Método - GET

###### URI:

`<API_URL>/mock/{id}/transacoes/{ano}/{mês}`

**Ação** | **Endpoint** | **Método**
------ | ----- | -----
Consultar | _/mock/{id}/transacoes/{ano}/{mês}_ | GET

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
