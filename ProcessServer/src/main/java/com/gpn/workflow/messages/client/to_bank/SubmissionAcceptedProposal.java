package com.gpn.workflow.messages.client.to_bank;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SubmissionAcceptedProposal implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("ClienteAceitaPropostaBanco")
                .correlate();
    }
}
