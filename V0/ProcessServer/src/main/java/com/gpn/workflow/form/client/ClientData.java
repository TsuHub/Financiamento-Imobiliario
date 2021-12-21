package com.gpn.workflow.form.client;

public class ClientData
{
    // Process: Escolha Canal
    // Form:    EscolhaCanal: Banco|Corretora
    private String requestDate;     // data da solicitação
    private String requesterName;   // nome do solicitante
    private String financingValue;  // valor da solicitação do financiamento
    private String income;          // rendimentos
    private String choicedChannel;   // Escolha por tratar com o banco ou corretora

    private String revenues;        // faturamento do solicitante
    private String costs;           // custos
    private String propertyStatus;  // condição do imóvel

    public ClientData(String requestDate, String requesterName, String financingValue, String income, String choicedChannel) {
        this.requestDate = requestDate;
        this.requesterName = requesterName;
        this.financingValue = financingValue;
        this.income = income;
        this.choicedChannel = choicedChannel;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getFinancingValue() {
        return financingValue;
    }

    public void setFinancingValue(String financingValue) {
        this.financingValue = financingValue;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getChoicedChannel() {
        return choicedChannel;
    }

    public void setChoiceChannel(String choicedChannel) {
        this.choicedChannel = choicedChannel;
    }

    public String getRevenues() {
        return revenues;
    }

    public void setRevenues(String revenues) {
        this.revenues = revenues;
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs;
    }

    public String getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }
}
