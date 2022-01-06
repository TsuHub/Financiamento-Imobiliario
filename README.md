<p align="center">============================================================================================</p>

							GESTÃO DE PROCESSOS DE NEGÓCIOS

<p align="center">============================================================================================</p>

Projeto de Orquestração de um processo de serviços (Automação de processo de negócio em BPMN 2.0


Orientador:
Prof. Dr. Marcelo Fantinato

Integrantes:
Caio Silvestre Almeida da Silva</br>
Guilherme Estevam Ferreira Putzeys</br>
João Pedro Rodrigues Camargo</br>
Tsuyoshi Yodogawa</br>

<p align="center">============================================================================================</p>

## Tecnologias utilizadas:

Para:

### - ProcessServer

	- Configuração do projeto:			Camunda Initializr (start.camunda.com)
	- Camunda Platform:				7.16
	- Bancos de dados:				H2 Database
	- JDK:						versão 11.0.12
	- Sistema de build:				Maven 4.0.0
	- Gerenciador de dependências:			Maven 4.0.0

### - Client (FinancingRequest)

	- Configuração do projeto: Spring Initializr (start.spring.io)
	- Spring Boot:					versão 2.6.1
	- JDK:						versão 11.0.12
	- Sistema de build:				Maven 4.0.0
	- Gerenciador de dependências:	Maven 4.0.0


### - ClientFinancingRequest

	- Java RMI
	- JDK 11
	- JavaFX


## O Projeto

Consiste na simulação da solicitação de um financiamento imobiliário com o BPMN 2.0

A arquitetura é organizada da seguinte maneira:
</br>

<p align="center"><img src="https://github.com/TsuHub/Financiamento-Imobiliario/blob/main/System%20Architecture/Architecture%20BPMS.png"></p>

</br>

Então o sistema BPMS (<i>Business and Process Management System</i>) está organizado em 3 camadas:</br>
</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Camunda Modeler - Para a modelagem dos processos;</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Repositório - Apenas uma simulação, logo os dados são carregados na RAM;</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. Camunda Platform Run - Para o servidor;</br>
	
Há ainda um servidor externo ao sistema, o Services Server, que poderá ser útil em futuras implementações</br>
com o intuito de intermediar o sistema com o cliente, para o preenchimento dos dados para a solicitação.</br>

## As entidades

São três piscinas:
</br>

<p align="center">
	<img src="https://github.com/TsuHub/Financiamento-Imobiliario/blob/main/System%20Architecture/Pools/Cliente.png"></br>
	<b>Cliente</b>
</p>
</br>
<p align="center">
	<img src="https://github.com/TsuHub/Financiamento-Imobiliario/blob/main/System%20Architecture/Pools/Corretora.png"></br>
	<b>Corretora</b>
</p>
</br>
<p align="center">
	<img src="https://github.com/TsuHub/Financiamento-Imobiliario/blob/main/System%20Architecture/Pools/Banco.png"></br>
	<b>Banco</b>
</p>
</br>

