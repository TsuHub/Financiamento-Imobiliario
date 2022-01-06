package com.gpn.workflow.form.client;

import java.util.HashMap;

import com.gpn.workflow.client_repository.ClientMap;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ClientDataSubmission implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ClientData clientData = new ClientData(
                (String) delegateExecution.getVariable("ECdata"),       // EC = Variáveis do formulário EscolhaCanal.form
                (String) delegateExecution.getVariable("ECnome"),
                (String) delegateExecution.getVariable("ECvalor"),
                (String) delegateExecution.getVariable("ECrendimentos"),
                (String) delegateExecution.getVariable("ECescolhaCanal")
        );
        ClientMap.add(clientData);

        String var = (String) delegateExecution.getVariable("ECnome");

        // ============================================================================
        // Bloco de testes
        System.out.println("\n\nANTES: ECnome = " + var);
        var = var.toUpperCase();
        delegateExecution.setVariable("ECnome", var);       // Definindo a variável (manuseando)
        System.out.println("\nDEPOIS: ECnome = " + var + "\n\n");
    }
}
