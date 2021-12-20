package com.gpn.workflow.form.bank;

import com.gpn.workflow.client_repository.ClientMap;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ReceiveDataFromClientRegisterForm implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        inputFormFilling(delegateExecution);
        inputVerifyIncome(delegateExecution);
    }

    public void inputFormFilling(DelegateExecution dE)
    {
        dE.setVariable("PFdata", ClientMap.getClient().getRequestDate());
        dE.setVariable("PFnome", ClientMap.getClient().getRequesterName());
        dE.setVariable("PFvalor", ClientMap.getClient().getFinancingValue());
        dE.setVariable("PFrendimentos", ClientMap.getClient().getIncome());
    }

    public void inputVerifyIncome(DelegateExecution dE) {
        double income = Double.parseDouble(ClientMap.getClient().getIncome());
        dE.setVariable("VRverificaRendimentos", income);
    }
}
