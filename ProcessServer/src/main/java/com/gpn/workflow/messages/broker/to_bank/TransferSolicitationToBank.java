package com.gpn.workflow.messages.broker.to_bank;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class TransferSolicitationToBank implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("TratamentoBanco")
                .correlate();
    }
}
