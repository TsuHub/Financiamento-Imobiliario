package com.gpn.workflow.form.bank;

import com.gpn.workflow.client_repository.ClientMap;
import com.gpn.workflow.form.client.ClientData;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InputAnalysisResult implements JavaDelegate
{
    private static final double APPROVED_CONSTANT = 0.1;

    private double profit;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        setClientPropertyStatus(delegateExecution);
        inputFields(delegateExecution);
        analysisConclusion(delegateExecution);
    }

    public void setClientPropertyStatus(DelegateExecution dE) {
        ClientMap.getClient().setPropertyStatus((String) dE.getVariable("VIcondicaoImovel"));
    }

    public void inputFields(DelegateExecution dE)
    {
        ClientData client = ClientMap.getClient();

        double income = Double.parseDouble(client.getIncome());
        double costs = Double.parseDouble(client.getCosts());
        String propertyStatus = client.getPropertyStatus();
        profit = income - costs;

        dE.setVariable("ARrendimentos", income);
        dE.setVariable("ARlucros", profit);
        dE.setVariable("ARcustos", costs);
        dE.setVariable("ARcondicaoImovel", propertyStatus);
    }

    public void analysisConclusion(DelegateExecution dE)
    {
        double financingValue = Double.parseDouble(ClientMap.getClient().getFinancingValue());
        String propertyStatus = ClientMap.getClient().getPropertyStatus();

        if (profit >= APPROVED_CONSTANT * financingValue) {
            if (propertyStatus.equals("Bom") || propertyStatus.equals("Ótimo")) dE.setVariable("ARconclusao", "Aprovado");
            else dE.setVariable("ARconclusao", "Negado");
        }
        else dE.setVariable("ARconclusao", "Negado");
    }
}
