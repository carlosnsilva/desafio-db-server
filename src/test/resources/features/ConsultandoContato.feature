# language: pt
# enconding:UTF-8
# Autor: Carlos Nunes

Funcionalidade: Consultando contatos

  Cenário: Com sucesso
    Dado o endpoint GET api-de-tarefas.herokuapp.com\contacts "<id>", "<descricao>"
    Quando a requisicao e enviada
    Entao retornara statushttP "<statusCode>"
    E o payload contendo a resposta da requisicao enviada para o endpoint GET api-de-tarefas.herokuapp.com\contacts "<payloadResponse>"
    Exemplos:
      |id  |descricao         |statusCode  |payloadResponse                           |
      |1.1 |Caso de sucesso   |200         |consultandoContato/cenario1/cenario1_1    |