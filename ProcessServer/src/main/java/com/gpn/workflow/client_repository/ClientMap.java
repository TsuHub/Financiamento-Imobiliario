package com.gpn.workflow.client_repository;

import com.gpn.workflow.form.client.ClientData;
import java.util.HashMap;

public class ClientMap
{
    // Estrutura com a lista de clientes
    private static HashMap<Integer, ClientData> clientMap = new HashMap<>();
    private static int clientID = 0;

    public static HashMap<Integer, ClientData> getClientMap() {
        return clientMap;
    }

    public static void setClientMap(HashMap<Integer, ClientData> clientMap) {
        ClientMap.clientMap = clientMap;
    }

    public static int getClientID() {
        return clientID;
    }

    public static void setClientID(int clientID) {
        ClientMap.clientID = clientID;
    }

    /**
     * Método responsável por adicionar um novo cliente ao HashMap
     * de clientes. O ID do cliente inicial começa com 0, e aumentado
     * de 1 em 1.
     *
     * @param clientData
     */
    public static void add(ClientData clientData) {
        ClientMap.clientID++;
        ClientMap.clientMap.put(clientID, clientData);
    }

    public static ClientData getClient() {
        return getClientMap().get(ClientMap.clientID);
    }
}
