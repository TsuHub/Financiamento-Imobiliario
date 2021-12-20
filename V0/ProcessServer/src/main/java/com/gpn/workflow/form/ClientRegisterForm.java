package com.gpn.workflow.form;

public class ClientRegisterForm
{
    private String requestDate;
    private String requesterName;
    private String financingValue;
    private String income;

    public ClientRegisterForm(String requestDate, String requesterName, String financingValue, String income) {
        this.requestDate = requestDate;
        this.requesterName = requesterName;
        this.financingValue = financingValue;
        this.income = income;
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
