package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Locale;

public class FormHandle implements JavaDelegate
{
    /*
        Exemplo de manipulação de uma variável de um processo.
        Esta classe é um teste para tornar a entrada (uma palavra) do
        usuário em maiúscula.
     */

    /**
     * Toda vez que uma atividade que referencia esta classe de delegação for executada,
     * uma nova instância desta classe será criada, i.e., para cada atividade, uma instância.
     * Isto garante que não ocorrerá nenhum erro com os dados (por exemplo de uma instância
     * acabar armazenando um valor de uma variável de outra atividade).
     *
     * @param delegateExecution
     * @throws Exception
     */
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        String formValue = (String) delegateExecution.getVariable("input");
        formValue = formValue.toUpperCase();
        delegateExecution.setVariable("input", formValue);
    }
}
