package com.gpn.workflow.form.client;

import com.gpn.workflow.client_repository.ClientMap;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InputChoicedChannel implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("ECBescolhaCorretoraBanco", ClientMap.getClient().getChoicedChannel());
    }
}
