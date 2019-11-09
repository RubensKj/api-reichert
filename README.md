# API - Reichert
API feita para o Lucas Reichert consumir no frontend para projeto pessoal.

API hospedada no Heroku - [API Link](https://api-reichert.herokuapp.com/api).

## JSON Form Requests

### Criar usuário
URL: `/api/usuario`
Request Method `POST`

```json
{
	"nomeCompleto": "Nome Sobrenome",
	"cpf": "CPF",
	"numeroCelular": "Número de celular",
	"quantiaPaga": 00.00,
	"tipoIngresso": "NORMAL ou VIP",
	"status": "NAO_CHEGOU ou CHEGOU"
}
```

### Buscar usuários
URL: `/api/usuarios`
Request Method `GET`

@Return
```json
[
  {
    "id": 1,
    "nomeCompleto": "Usuário 1",
    "cpf": "CPF 1",
    "numeroCelular": "Número de celular 1",
    "quantiaPaga": 00.00,
    "tipoIngresso": "NORMAL",
    "status": "CHEGOU"
  },
  {
    "id": 2,
    "nomeCompleto": "Usuário 2",
    "cpf": "CPF 2",
    "numeroCelular": "Número de celular 2",
    "quantiaPaga": 20.00,
    "tipoIngresso": "VIP",
    "status": "NAO_CHEGOU"
  }
]
```

### Buscar usuário por ID
URL: `/api/usuarios/Número ID`
Request Method `GET`

```json
{
  "id": 2,
  "nomeCompleto": "Usuário 2",
  "cpf": "CPF 2",
  "numeroCelular": "Número de celular 2",
  "quantiaPaga": 20.00,
  "tipoIngresso": "VIP",
  "status": "NAO_CHEGOU"
 }
```

### Editar usuário
URL: `/api/editar`
Request Method `PUT`

```json
{
    "id": 2,
    "nomeCompleto": "Usuário 2",
    "cpf": "CPF 2",
    "numeroCelular": "Número de celular 2",
    "quantiaPaga": 22.25,
    "tipoIngresso": "NORMAL",
    "status": "CHEGOU"
}
```

### Deletar usuário
URL: `/api/delete/Número ID`
Request Method `DELETE`

```
Usuário deletado com sucesso!
```
