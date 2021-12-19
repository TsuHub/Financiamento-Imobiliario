package com.gpn.workflow.messages.bank.to_client;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NotificationRegister implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("BancoNotificaCadastroCliente")
                .correlate();
    }
}
