package ServerAPIs;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class FinancingRequestConcrete implements FinancingRequest
{
    private int partID;
    private String partName;
    private String partDescription;
    private ArrayList<FinancingRequest> subFinancingRequestList;

    public FinancingRequestConcrete(int id, String name, String description){
        this.partID = id;
        this.partName = name;
        this.partDescription = description;
        this.subFinancingRequestList = new ArrayList<>();
    }

    @Override
    public String partPrintTest() throws RemoteException {
        System.out.println("Executando o método partPrintTest() de ServerAPIs.FinancingRequest.java");
        return "Server.Server : implementacão do método da interface ServerAPIs.FinancingRequest funcionando corretamente.";
    }

    @Override
    public int getPartID() throws RemoteException {
        return this.partID;
    }

    @Override
    public String getPartName() throws RemoteException {
        return this.partName;
    }

    @Override
    public String getPartDescriptions() throws RemoteException {
        return this.partDescription;
    }

    @Override
    public ArrayList<FinancingRequest> getSubpartsList() throws RemoteException {
        return this.subFinancingRequestList;
    }

    @Override
    public int getSubpartListSize() throws RemoteException {
        return this.subFinancingRequestList.size();
    }

    @Override
    public void addPartToSubPartList(int partID, String partName, String partDescription, int quantity) throws RemoteException
    {
        FinancingRequestConcrete part = new FinancingRequestConcrete(partID, partName, partDescription);

        for (int i = 0; i < quantity; i++) {
            this.subFinancingRequestList.add(part);
        }
    }

    @Override
    public void removePartFromRepository(int id) throws RemoteException {
        this.subFinancingRequestList.remove(id);
        System.out.printf("Peça de ID %d removida a lista de subcomponentes.\n", id);
    }

    @Override
    public void showListOfSubparts() throws RemoteException
    {
        for (FinancingRequest financingRequest : this.subFinancingRequestList) {
            System.out.println(financingRequest.getPartName());
        }
    }

    @Override
    public int verifyIfNameExist(String name) throws RemoteException
    {
        int index = -1;

        for (FinancingRequest p : this.subFinancingRequestList) {
            if (p.getPartName().equals(name))
                index = this.subFinancingRequestList.indexOf(p);
        }
        return index;
    }
}
