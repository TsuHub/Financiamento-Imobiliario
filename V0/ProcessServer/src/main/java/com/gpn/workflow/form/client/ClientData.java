package com.gpn.workflow.form.client;

public class ClientData
{
    private String requestDate;
    private String requesterName;
    private String financingValue;
    private String income;
    private String choiceChannel;

    public ClientData(String requestDate, String requesterName, String financingValue, String income, String choiceChannel) {
        this.requestDate = requestDate;
        this.requesterName = requesterName;
        this.financingValue = financingValue;
        this.income = income;
        this.choiceChannel = choiceChannel;
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
}
