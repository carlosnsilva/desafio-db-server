# language: pt
# enconding:UTF-8
# Autor: Carlos Nunes

Funcionalidade: Alterando contato

  Cenário: Com sucesso
    Dado o endpoint PUT api-de-tarefas.herokuapp.com\contacts "<id>", "<descricao>"
    Quando envia  requisicao "<payloadRequest>"
    Entao retornara StatusHttp "<statusCode>"
    E o payload contendo a resposta da requisicao enviada para o endpoint PUT api-de-tarefas.herokuapp.com\contacts "<payloadResponse>"
    Exemplos:
      |id  |descricao         |payloadRequest                             |statusCode  |payloadResponse                         |
      |1.1 |Caso de sucesso   |alterandoContato/cenario1/cenario1_1       |200         |alterandoContato/cenario1/cenario1_1    |