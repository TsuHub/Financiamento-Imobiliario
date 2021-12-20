package com.gpn.workflow.form;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Locale;

public class ClientDataController implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ClientData clientData = new ClientData(
                (String) delegateExecution.getVariable("ECdata"),
                (String) delegateExecution.getVariable("ECnome"),
                (String) delegateExecution.getVariable("ECvalor"),
                (String) delegateExecution.getVariable("ECrendimentos")
        );

        String var = (String) delegateExecution.getVariable("ECnome");
        var = var.toUpperCase();
        System.out.println("\n\nANTES: ECnome = " + var + "\n\n");

        delegateExecution.setVariable("ECnome", var);

        System.out.println("\n\nDEPOIS: ECnome = " + var + "\n\n");
    }
}
