package com.gpn.workflow.form.bank;

import com.gpn.workflow.client_repository.ClientMap;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class StoreFinanceData implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        inicializeClientDataVars(delegateExecution);
    }

    public void inicializeClientDataVars(DelegateExecution dE) {
        ClientMap.getClient().setCosts((String) dE.getVariable("VSFcustos"));
    }
}
