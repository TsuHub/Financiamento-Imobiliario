const { Client, logger } = require("camunda-external-task-client-js");
const { Variables } = require("camunda-external-task-client-js");

// configuration for the Client:
//  - 'baseUrl': url to the Process Engine
//  - 'logger': utility to automatically log important events
const config = { baseUrl: "http://localhost:8080/engine-rest", use: logger };

// create a Client instance with custom configuration
const client = new Client(config);

// susbscribe to the topic: 'creditScoreChecker'
client.subscribe("RegistroSolicitacao", async function ({ task, taskService }) {
    const var1 = task.variables.get("qualquerCoisa")
    console.log("JS: Qualquer coisa foi impressa: " + parseInt(var1, 10));
    console.log('\n');
    console.log("JS: Convertido em número: " + num);

    const var2 = "JS: Teste: resposta do servidor";
    const processVariables = new Variables();
    processVariables.set("var2", var2);

    await taskService.complete(task, processVariables);
});