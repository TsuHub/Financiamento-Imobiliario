package com.gpn.workflow.messages.broker.to_client;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendApprovedNotification implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        //com.gpn.workflow.messages.broker.to_client.SendApprovedNotification
        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("CorretoraNotificaAprovacaoCliente")
                .correlate();
    }
}
