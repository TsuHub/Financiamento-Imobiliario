package org.usp.each.gpn.workflow.messages.bank_to_client;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SubmissionOfContracts implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("EnvioMinutas")
                .correlate();
    }
}
