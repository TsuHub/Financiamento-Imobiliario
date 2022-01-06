package com.financingrequest.models;

public class FinancingRequestModel
{
    private String requestDate;         // Data da solicitação
    private String requesterName;       // Nome do solicitante
    private double financingValue;      // Valor do financiamento
    private double income;              // Rendimentos do solicitante

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

    public double getFinancingValue() {
        return financingValue;
    }

    public void setFinancingValue(double financingValue) {
        this.financingValue = financingValue;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
