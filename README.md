# ValidatorCPF
Projeto de integração CI/CD para a cadeira de Metodologias Ageis

[![Build Status](https://travis-ci.org/SnowGhost21/ValidatorCPF.svg?branch=master)](https://travis-ci.org/SnowGhost21/ValidatorCPF)

# Utilização

Para realizar o teste utilizando a API se deve realizar uma chamada POST para o endpoint abaixo e inserindo no corpo o valor "value" o CPF completo apenas números.

https://validator-cpf.herokuapp.com/validate

# User Cases
**User Case: 1.0** 

Eu enquanto usuário do sistema bancário, quero realizar uma pré validação do CPF do usuário de forma off-line para de evitar fraudes de CPFs inválidos.

Critérios de aceitação: 
- Inserir um código CPF;
- Realizar as validações presentes abaixo;
- Receber a informação de CPF válido ou inválido

---


**User Case 1.1**

Eu enquanto usuário do sistema bancário, a fim de proteção de dados inválidos não posso aceitar CPFS com valores repetidos. Ex: 00000000000, 11111111111...

Critérios de aceitação:
- Inserir um código de CPF;
- Se digitar um código de CPF contendo apenas um número deverá encerrar a aplicação com a mensagem "CPF inválido, informe um valor correto e tente novamente";
- Caso passe na validação, verificar próxima análise


---

**User Case 1.2**

Eu enquanto usuário do sistema bancário, quero realizar uma pré validação do CPF sendo o seu tamanho igual a 11 dígitos seguindo o padrão definido pela Receita Federal Brasileira.

Critérios de aceitação:
- Inserir um código CPF;
- Validar se a quantidade de caracteres recebido é igual a 11;
- Caso falhe encerrar a aplicação com a mensagem “CPF deve conter 11 números”;
- Caso passe na validação, verificar próxima análise

---

**User Case 1.3**

Eu enquanto usuário do sistema bancário, quero realizar uma pré validação do CPF enquanto o valor inserido não for vazio ou nulo.

Critérios de aceitação:
- Inserir um código CPF;
- Validar se contém caracteres recebidos, caso não receba nada, ou seja, em branco encerrar a aplicação com a mensagem “CPF não pode ser vazio ou nulo”;
- Caso passe na validação, verificar próxima análise

---

**User Case 1.4**

Eu enquanto usuário do sistema bancário, quero realizar uma pré validação do CPF sendo aceitado apenas dígitos inteiros, não podendo ser inseridos espaços, traços ou caracteres especiais.

Critérios de aceitação:
- Inserir um código CPF;
-Validar se contem apenas dígitos numéricos, bloqueando caracteres normais ou especiais, caso o valor contenha algum desses, encerrar a aplicação com a mensagem “CPF deve conter apenas números”;
- Caso passe na validação, verificar próxima análise.


---


**User Case 1.5**

Eu enquanto usuário do sistema bancário, quero realizar uma pré validação do CPF sendo os últimos dígitos verificadores seguindo a regra de acordo com o link abaixo.

Link: http://www.receita.fazenda.gov.br/publico/Legislacao/atos/AtosConjuntos/AnexoIADEConjuntoCoratCotec0012002.doc

Critérios de aceitação:
- Inserir um código de CPF;
- Válidar o código matemático presente no link no caso de usuário, caso o valor seja negativo, encerrar a aplicação com a mensagem “Erro na validação, tente novamente!”;
- Caso valor seja positivo, encerrar a aplicação com a mensagem “CPF válido!”


---

# Próximos passos

- Possibilidade de análise na receita federal;
- Consulta a SPC/Serasa
- Histórico de consultas
