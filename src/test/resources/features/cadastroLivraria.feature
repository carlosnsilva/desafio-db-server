# language: pt
# enconding:UTF-8
# Autor: Carlos Nunes

Funcionalidade: Cadastrando na livraria

  Cenario: Com password numerico
    Dado a url demoqa\login
    Quando registro um novo usuario com a senha numerica
    Entao recebo mensagem de erro

  Cenario: Com sucesso
    Dado a url demoqa\login
    Quando registro um novo usuario com as informacoes corretas
    Entao valido com sucesso
    E realizado login

  Cenario: Acessando Ebook
    Dado a url demoqa\login
    Quando realizo login com sucesso
    E vou até a livraria
    E pesquiso por um livro
    Entao valido o codigo ISBN do livro
    E adiciono o livro a minha colecao
    E valido se o livro foi adicionado.