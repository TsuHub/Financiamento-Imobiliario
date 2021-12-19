package com.gpn.workflow.messages.bank.to_broker;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SubmissionOfProposalsToBroker implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("BancoEnvioPropostasCorretora")
                .correlate();
    }
}
