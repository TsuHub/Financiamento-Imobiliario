package com.gpn.workflow.form.bank;

import com.gpn.workflow.client_repository.ClientMap;
import com.gpn.workflow.form.client.ClientData;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InputAnalysisResult implements JavaDelegate
{
    private double profit;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        inputFields(delegateExecution);
        analysisConclusion(delegateExecution);
    }

    public void inputFields(DelegateExecution dE)
    {
        ClientData client = ClientMap.getClient();

        double income = Double.parseDouble(client.getIncome());
        double costs = Double.parseDouble(client.getCosts());
        profit = income - costs;

        dE.setVariable("ARrendimentos", income);
        dE.setVariable("ARlucros", profit);
        dE.setVariable("ARcustos", costs);
    }

    public void analysisConclusion(DelegateExecution dE) {
        if (profit > 0) dE.setVariable("ARconclusao", "Aprovado");
        else dE.setVariable("ARconclusao", "Negado");
    }
}
