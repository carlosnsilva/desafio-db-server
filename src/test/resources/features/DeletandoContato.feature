# language: pt
# enconding:UTF-8
# Autor: Carlos Nunes

Funcionalidade: Deletando contatos

  Cenário: Com sucesso
    Dado o endpoint DEL api-de-tarefas.herokuapp.com\contacts "<id>", "<descricao>"
    Quando envia a requisicao
    Entao retornara statushttp "<statusCode>"
    Exemplos:
      |id  |descricao         |statusCode  |
      |1.1 |Caso de sucesso   |204         |