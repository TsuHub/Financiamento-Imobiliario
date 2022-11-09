
## <p align="center">GESTÃO DE PROCESSOS DE NEGÓCIOS</p>

</br><p align="center">Projeto de Orquestração de um processo de serviços (Automação de processo de negócio em BPMN 2.0</p>

<p align="center">===========================================================================</p>

## Tecnologias utilizadas:

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

Consiste na simulação da solicitação de um financiamento imobiliário em BPMN 2.0

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

São três piscinas:</br>
link dos <a href="https://github.com/TsuHub/Financiamento-Imobiliario/tree/main/ProcessServer/src/main/resources">modelos</a> no projeto.
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


### <a href="https://github.com/TsuHub/Financiamento-Imobiliario/tree/main/ProcessServer">ProcessServer</a>

Este sistema está organizado em três camadas:</br>
1. <a href="https://github.com/TsuHub/Financiamento-Imobiliario/tree/main/ProcessServer/src/main/java/com/gpn/workflow/client_repository">Repositório dos dados do cliente</a></br>
&nbsp;&nbsp;&nbsp;&nbsp;A simulação da persistências dos dados ocorre em uma estrutura Map, onde é guardado os dados de cada <a href="https://github.com/TsuHub/Financiamento-Imobiliario/blob/main/ProcessServer/src/main/java/com/gpn/workflow/form/client/ClientData.java">cliente/solicitante</a>.</br></br>
2. <a href="https://github.com/TsuHub/Financiamento-Imobiliario/tree/main/ProcessServer/src/main/java/com/gpn/workflow/form">Formulários de preenchimentos das entidades</a></br>
&nbsp;&nbsp;&nbsp;&nbsp;Na camada de form, existem ainda três subdivisões, uma para cada uma das entidades. Esta camada é responsável por armazenar e tratar os dados inputados pelo cliente.</br></br>
3. <a href="https://github.com/TsuHub/Financiamento-Imobiliario/tree/main/ProcessServer/src/main/java/com/gpn/workflow/messages">Camada de transição entre piscinas (mensagens)</a></br>
&nbsp;&nbsp;&nbsp;&nbsp;Esta camada é responsável por fazer a transição entre processos de piscinas diferentes, i.e., são as classes responsáveis por permitir a execução sequencial de um processo da piscina Cliente para um processo da piscina Corretora, por exemplo.
</br></br>
</br>
<p align="center">
	<img src="https://github.com/TsuHub/Financiamento-Imobiliario/blob/main/Modelo%20Geral.png"></br>
	<b>Modelagem completa das entidades</b>
</p>
