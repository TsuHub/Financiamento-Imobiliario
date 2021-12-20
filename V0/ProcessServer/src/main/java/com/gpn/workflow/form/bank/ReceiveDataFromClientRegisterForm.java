package com.gpn.workflow.form.bank;

import com.gpn.workflow.client_repository.ClientMap;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ReceiveDataFromClientRegisterForm implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        delegateExecution.setVariable("PFdata", ClientMap.getClient().getRequestDate());
        delegateExecution.setVariable("PFnome", ClientMap.getClient().getRequesterName());
        delegateExecution.setVariable("PFvalor", ClientMap.getClient().getFinancingValue());
        delegateExecution.setVariable("PFrendimentos", ClientMap.getClient().getIncome());
    }
}
