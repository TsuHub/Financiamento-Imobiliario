package com.gpn.workflow.form.broker;

import com.gpn.workflow.client_repository.ClientMap;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InputCheckRequest implements JavaDelegate
{
    private static final double FINANCING_LIMIT = 50000.00;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("VLvalorLimite", inputAcceptedOrRejected());
    }

    public String inputAcceptedOrRejected()
    {
        double financingValue = Double.parseDouble(ClientMap.getClient().getFinancingValue());
        // double income = Double.parseDouble(ClientMap.getClient().getIncome());

        if (financingValue <= FINANCING_LIMIT) return "Sim";
        return "Não";
    }
}
