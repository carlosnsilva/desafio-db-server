# language: pt
# enconding:UTF-8
# Autor: Carlos Nunes

Funcionalidade: Cadastrando contato

  Cenário: Com sucesso
    Dado o endpoint POST api-de-tarefas.herokuapp.com\contacts "<id>", "<descricao>"
    Quando envia a requisicao "<payloadRequest>"
    Entao retornara statusHttp "<statusCode>"
    E o payload contendo a resposta da requisicao enviada para o endpoint POST https://api-de-tarefas.herokuapp.com/contacts "<payloadResponse>"
    Exemplos:
    |id  |descricao         |payloadRequest                             |statusCode  |payloadResponse                           |
    |1.1 |Caso de sucesso   |cadastrandoContato/cenario1/cenario1_1     |201         |cadastrandoContato/cenario1/cenario1_1    |