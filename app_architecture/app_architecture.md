# 1. Princípios de Arquitetura Comuns

## 1.1. Separação de Conceitos

## 1.2. UI Baseada em Modelos de Dados

## 1.3. Única Fonte de Informações

## 1.4. Flúxo de Dados Unidirecional

# 2. Arquitetura Recomendada

Esta seção demonstra como estruturar o app seguindo as práticas recomendadas.

> [!Note]
> As recomendações e práticas recomendadas apresentadas nesta página podem ser aplicadas a vários tipos de apps para permitir o escalonamento, a melhoria da qualidade e a robustez, além de facilitar os testes. No entanto, trate-as como orientações e as adapte conforme necessário.

Considerando os princípios de arquitetura comuns mencionados na seção anterior, cada aplicativo precisa ter pelo menos duas camadas:

- A camada de IU que mostra os dados do aplicativo na tela.
- A camada de dados que contém a lógica de negócios do app e expõe os dados do aplicativo.

É possível adicionar uma camada extra conhecida como camada de domínios para simplificar e reutilizar as interações entre a IU e as camadas de dados.

<br>
<div align="center">
<img style="width: 500px;" src="../assets/mad-arch-overview.png"/>
</div>
<br>

> [!Note]
> As setas nos diagramas deste guia representam as dependências entre classes. Por exemplo, a camada do domínio depende das classes de camada de dados.

Sobre cada camada cabe destacar:

## UI Layer

## Data Layer

## Domain Layer
