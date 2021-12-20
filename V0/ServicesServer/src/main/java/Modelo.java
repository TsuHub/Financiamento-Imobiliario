import java.util.logging.Logger;
import java.awt.Desktop;
import java.net.URI;

import org.camunda.bpm.client.ExternalTaskClient;

public class Modelo
{
    private final static Logger LOGGER = Logger.getLogger(Modelo.class.getName());
    private static int amountInstances = 0;

    public static void main(String args[])
    {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")       // Endpoint onde é feito os deploys do modelo e dos forms.
                .asyncResponseTimeout(10000)                        // tempo limite de resposta do servidor para o cliente (em milésimos de segundo)
                .build();

        // registro/inscrição de uma tarefa externa, conforme especificado no processo
        client.subscribe("RegistrarSolicitacao")   // Tópico do processo - A busca do processo é feita por este programa através do Tópico dado ao processo na modelagem.
                .lockDuration(1000)                 // Duração do bloqueio padrão é de 20 segundos - alterado para 10 segundos
                .handler((externalTask, externalTaskService) -> {

                    // Lógica de negócio aqui

                    // Acessando a variável do processo -
                    String item = (String) externalTask.getVariable("qualquerCoisa");
                    Long amount = (Long) externalTask.getVariable("amount");
                    amountInstances ++;

                    LOGGER.info("\nValor de 'amount': " + amount + "\nValor de 'item': " + item + "\n" + "\nQuantidade de solicitações: " + amountInstances);

                    try {
                        Desktop.getDesktop().browse(new URI("https://docs.camunda.org/get-started/quick-start/complete"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Completar tarefa
                    externalTaskService.complete(externalTask);
                }).open();
    }
}
