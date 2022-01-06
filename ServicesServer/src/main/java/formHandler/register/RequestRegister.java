package formHandler.register;

import org.camunda.bpm.client.ExternalTaskClient;

import java.awt.*;
import java.net.URI;
import java.util.logging.Logger;

public class RequestRegister
{
    private final static Logger LOGGER = Logger.getLogger(RequestRegister.class.getName());
    private static int amountInstances;

    public static void externalTaskClientRegisterRequest()
    {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")       // Endpoint onde é feito os deploys do modelo e dos forms.
                .asyncResponseTimeout(10000)                        // tempo limite de resposta do servidor para o cliente (em milésimos de segundo)
                .build();

        // registro/inscrição de uma tarefa externa, conforme especificado no processo
        client.subscribe("RegistrarSolicitacao")      // Tópico do processo - A busca do processo é feita por este programa através do Tópico dado ao processo na modelagem.
                .lockDuration(1000)                     // Duração do bloqueio padrão é de 20 segundos - alterado para 10 segundos
                .handler((externalTask, externalTaskService) -> {

                    // Acessando a variável do processo - PF = PreenchimentoFormulario.form
                    String requestDate = (String) externalTask.getVariable("PFdata");
                    String requesterName = (String) externalTask.getVariable("PFnome");
                    double financingValue = Double.parseDouble(externalTask.getVariable("PFvalor"));
                    double income = Double.parseDouble(externalTask.getVariable("PFrendimentos"));
                    amountInstances ++;

                    LOGGER.info("\nServicesServer.formHandler.registerRequestRegister:" +
                            "\n    Data da solicitação: " + requestDate +
                            "\n    Nome do solicitante: " + requesterName +
                            "\n    Valor do financiamento: " + financingValue + 2 +
                            "\n    Rendimentos do solicitante: " + income +
                            "\n    Quantidade de solicitações: " + amountInstances);

                    try {
                        Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Completar tarefa
                    externalTaskService.complete(externalTask);
                }).open();
    }

    public static int getAmountInstances() {
        return amountInstances;
    }

    public static void setAmountInstances(int amountInstances) {
        RequestRegister.amountInstances = amountInstances;
    }
}
