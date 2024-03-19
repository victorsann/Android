# Princípios de arquitetura comuns

## Separação de Conceitos

## UI Baseada em Modelos de Dados

## Única Fonte de Informações

## Flúxo de Dados Unidirecional

# Arquitetura Recomendada

Esta seção demonstra como estruturar o app seguindo as práticas recomendadas.

> [!Note]
> As recomendações e práticas recomendadas apresentadas nesta página podem ser aplicadas a vários tipos de apps para permitir o escalonamento, a melhoria da qualidade e a robustez, além de facilitar os testes. No entanto, trate-as como orientações e as adapte conforme necessário.

Considerando os princípios de arquitetura comuns mencionados na seção anterior, cada aplicativo precisa ter pelo menos duas camadas:

- A camada de IU que mostra os dados do aplicativo na tela.
- A camada de dados que contém a lógica de negócios do app e expõe os dados do aplicativo.

É possível adicionar uma camada extra conhecida como camada de domínios para simplificar e reutilizar as interações entre a IU e as camadas de dados.

<img align="center" style="width: 500px;" src="../assets/mad-arch-overview.png"/>

<br>

> [!Note]
> As setas nos diagramas deste guia representam as dependências entre classes. Por exemplo, a camada do domínio depende das classes de camada de dados.
