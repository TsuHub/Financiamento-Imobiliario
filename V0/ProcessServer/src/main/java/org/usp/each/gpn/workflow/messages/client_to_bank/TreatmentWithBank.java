package org.usp.each.gpn.workflow.messages.client_to_bank;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class TreatmentWithBank implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
    /*
        String question = (String) delegateExecution.getVariable("question");

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("TratamentoBanco")
                .setVariable("question", question)
                .correlate();
    */

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("TratamentoBanco")
                .correlate();
    }
}
