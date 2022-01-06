package ServerAPIs;

import FinancingRequestRepositories.RepositoryHandler;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * lastID é uma variável de controle dos IDs das peças existentes
 * no repositório. A variável em questão é inicializada com 0.
 * Ao adicionar uma peça ao repositório, a variável é atribuída
 * ao ID desta peça. Quando uma peça é removida do repositório,
 * o ID da peça removida é atribuída a lastID, assim este ID
 * estará disponível para ser dado a uma nova peça.
 * Então quando uma peça é removida, seu ID fica disponível para
 * uso, e quem passa a guardar este ID é a variável availableID,
 * para que este ID seja reatribuída para outra peça.
 */

public class FinancingRequestRepositoryConcrete implements FinancingRequestRepository
{
    private final String serverName;
    private final String repoName;
    private ArrayList<FinancingRequest> listFinancingRequestRepository;
    private ArrayList<FinancingRequest> listSubpartOfFinancingRequest;
    private static int lastID;         // Variável que contém o último índice da lista.
    private static int availableID;    // Variável que contém o último índice disponível entre duas já existentes, resultante de uma remoção de peça.
                                // Caso seja igual a -1, é porque não há um índice disponível para reatribuição.

    public FinancingRequestRepositoryConcrete(String sName, String rName) {
        this.serverName = sName;
        this.repoName = rName;
        this.listFinancingRequestRepository = new ArrayList<>();
        this.listSubpartOfFinancingRequest = new ArrayList<>();
        lastID = 0;
        availableID = -1;
    }

    @Override
    public String partRepositoryPrintTest() {
        System.out.println(this.getServerName() + " : Executando o método partRepositoryPrintTest() de ServerAPIs.FinancingRequestRepository.java");
        return "FinancingRequestRepositoryConcrete : implementacão do método da interface ServerAPIs.FinancingRequestRepository funcionando corretamente.";
    }

    @Override
    public String getServerName() {
        return this.serverName;
    }

    @Override
    public String getRepositoryName() {
        return this.repoName;
    }

    @Override
    public int getNumberOfParts() {
        System.out.println(this.getServerName() + " : Cliente solicita a quantidade de peças no repositório.");
        return this.listFinancingRequestRepository.size();
    }

    @Override
    public ArrayList<FinancingRequest> getRepository() throws RemoteException {
        return this.listFinancingRequestRepository;
    }

    @Override
    public String[][] getRepoMatrix() throws RemoteException
    {
        System.out.println(this.getServerName() + " : FinancingRequestRepositoryConcrete.getRepoMatrix:");

        int l = this.listFinancingRequestRepository.size();
        int c = 2;          // Uma coluna para o ID e outra para o nome da peça

        String repoMatrix[][] = new String[l][c];

        int a = 0;
        for (FinancingRequest financingRequest : this.listFinancingRequestRepository) {
            for (int j = 0; j < c; j++){
                if (j == 0) repoMatrix[a][j] = String.valueOf(financingRequest.getPartID());
                else repoMatrix[a][j] = financingRequest.getPartName();    // 20 espaços
            }
            a++;
        }

        System.out.println("\nFinancingRequestRepositoryConcrete.getRepoMatrix:");
        for (int i = 0; i < l; i++) {
            if (Integer.parseInt(repoMatrix[i][0]) < 10 )
                System.out.println("    " + repoMatrix[i][0] + "    " + repoMatrix[i][1]);

            else
                System.out.println("   " + repoMatrix[i][0] + "    " + repoMatrix[i][1]);
        }
        System.out.println();

        return repoMatrix;
    }

    //==================================================================================
    // Bloco referente a chamada de funções referente a peças

    @Override
    public String getPartName(int id) throws RemoteException
    {
        String name = "";

        int arrayID = verifyIfIDAlreadyExist(id);

        if (arrayID != -1) {
            name = this.listFinancingRequestRepository.get(arrayID).getPartName();
        }

        return name;
    }

    @Override
    public String getPartDescription(int id) throws RemoteException
    {
        String description = "";
        int arrayID = verifyIfIDAlreadyExist(id);

        if (arrayID != -1) {
             description = this.listFinancingRequestRepository.get(arrayID).getPartDescriptions();
        }
        return description;
    }

    @Override
    public FinancingRequest getPiece(int id) throws RemoteException
    {
        int arrayID = verifyIfIDAlreadyExist(id);

        if (arrayID == -1) {
            System.out.println(this.getServerName() + " : A peça de id " + id + " não existe.");
            return null;
        }
        System.out.println(this.getServerName() + " : Peça de id " + id + " solicitada pelo cliente.");
        return this.listFinancingRequestRepository.get(arrayID);
    }

    @Override
    public ArrayList<FinancingRequest> getSubpartList(int id) throws RemoteException {
        int arrayID = verifyIfIDAlreadyExist(id);
        return this.listFinancingRequestRepository.get(arrayID).getSubpartsList();
    }

    @Override
    public String[][] getSubpartMatrix(int id) throws RemoteException
    {
        int arrayID = verifyIfIDAlreadyExist(id);

        this.listSubpartOfFinancingRequest = this.listFinancingRequestRepository.get(arrayID).getSubpartsList();

        int l = this.listSubpartOfFinancingRequest.size();
        int c = 2;          // Uma coluna para o nome da peça e outra para a quantidade de subcomponentes
        String subpartMatrix[][] = new String[l][c];

        //===================================================================
        // Alocando primeiramente apenas os nomes das peças.
        // Posteriormente as peças com nomes repetidos serão contabilizados
        // e alocados na matriz "subpartMatriz"

        int a = 0;
        for (FinancingRequest financingRequest : this.listSubpartOfFinancingRequest) {
            subpartMatrix[a][0] = financingRequest.getPartName();
            a++;
        }

        //===================================================================
        // Contabilizando a quantidade de peças repetidas

        for (int i = 0; i < subpartMatrix.length; i++)
        {
            int quantity = 0;
            for (int j = 0; j < subpartMatrix.length; j++) {
                if (subpartMatrix[i][0].equals(subpartMatrix[j][0]))
                    quantity++;
            }
            subpartMatrix[i][1] = String.valueOf(quantity);
        }
        //===================================================================
        // Apenas imprimindo

        System.out.println();
        System.out.println(this.getServerName() + " : FinancingRequestRepositoryConcrete.getSubpartMatrix:");
        for (int i = 0; i < subpartMatrix.length; i++) {
            System.out.println("Peça: " + subpartMatrix[i][0] + "      Qntd: " + subpartMatrix[i][1]);
        }
        System.out.println();

        //===================================================================
        // Definindo o número de linhas que a nova matriz vai possuir

        l = 0;
        for (int i = 0; i < subpartMatrix.length; i++) {
            if (Integer.parseInt(subpartMatrix[i][1]) > 1)
                i = i + Integer.parseInt(subpartMatrix[i][1]) - 1;

            l++;
        }

        //===================================================================
        // Atribuindo os nomes das peças com suas respectivas
        // quantidades. Esta nova matriz não possui elementos
        // repetidos.

        String subpartMatrixResult[][] = new String[l][c];
        int k = 0;
        for (int i = 0; i < subpartMatrix.length; i++) {
            subpartMatrixResult[k][0] = subpartMatrix[i][0];
            subpartMatrixResult[k][1] = subpartMatrix[i][1];

            if (Integer.parseInt(subpartMatrix[i][1]) > 1)
                i = i + Integer.parseInt(subpartMatrix[i][1]) - 1;

            k++;
        }

        //===================================================================
        // Impressão da matriz resultante

        System.out.println();
        System.out.println(this.getServerName() + " : FinancingRequestRepositoryConcrete.getSubpartMatrix:");
        for (int i = 0; i < subpartMatrixResult.length; i++) {
            System.out.println("Peça: " + subpartMatrixResult[i][0] + "      Qntd: " + subpartMatrixResult[i][1]);
        }
        System.out.println();

        return subpartMatrixResult;
    }

    @Override
    public void addToSubpartList(int idToAdd, int idToReceive, String partName, String partDescription, int quantity) throws RemoteException {
        int arrayID = verifyIfIDAlreadyExist(idToReceive);
        this.listFinancingRequestRepository.get(arrayID).addPartToSubPartList(idToAdd, partName, partDescription, quantity);
        System.out.printf(this.getServerName() + " : Peça de ID %d adicionada %d vezes como subcomponente da peça de ID %d.\n", idToAdd, quantity, idToReceive);
    }

    @Override
    public void removeFromSubpartList(String nameToRemove, int idPart, int quantity) throws RemoteException{
        int arrayID = verifyIfIDAlreadyExist(idPart);

        this.listSubpartOfFinancingRequest = this.listFinancingRequestRepository.get(arrayID).getSubpartsList();

        int auxID = -1;
        for (FinancingRequest p : this.listSubpartOfFinancingRequest)
        {
            auxID = p.verifyIfNameExist(nameToRemove);
            if (auxID != -1) listSubpartOfFinancingRequest.remove(auxID);
        }

        System.out.println();
        System.out.println(this.getServerName() + " : FinancingRequestRepositoryConcrete.removeFromSubpartList : Peça de ID " + idPart + " removida.");
    }
    //==================================================================================

    @Override
    public void inicializePartRepositoryList(){
        RepositoryHandler.initializeRepositoryTxt(this.repoName, this.listFinancingRequestRepository);
    }

    @Override
    public void addPartToRepository(String partName, String partDescription) throws RemoteException
    {
        FinancingRequestConcrete part;

        for (FinancingRequest p : listFinancingRequestRepository) {
            if (verifyIfIDAlreadyExist(p.getPartID()) == -1) availableID = p.getPartID();
            availableID++;
        }
        availableID++;

        part = new FinancingRequestConcrete(availableID, partName, partDescription);
        availableID = -1;

        this.listFinancingRequestRepository.add(part);

        RepositoryHandler.addPartToRepoTxt(this.repoName, part);

        System.out.printf(this.getServerName() + " : A peça %s, de ID %d foi adicionado ao repositório %s.\n", part.getPartName(), part.getPartID(), this.getRepositoryName());
    }

    @Override
    public void removePartFromRepository(int id) throws RemoteException
    {
        availableID = verifyIfIDAlreadyExist(id);

        if (availableID != -1) {
            this.listFinancingRequestRepository.remove(availableID);
            RepositoryHandler.removePartRepoTxt(this.repoName, id);
            System.out.println(this.getServerName() + " : A peça de ID: " + availableID + " foi removida do repositório.");
        }
    }

    @Override
    public void showListOfPieces() throws RemoteException {
        System.out.println(this.getServerName() + " : Cliente solicita a lista de peças no repositório.");
        this.listFinancingRequestRepository.forEach(part ->
        {
            try
            {
                System.out.printf(this.getServerName() + " : ID : %d    Nome: %s    Descrição: %s\n", part.getPartID(), part.getPartName(), part.getPartDescriptions());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void showListOfSubparts(int id) throws RemoteException {
        int arrayID = verifyIfIDAlreadyExist(id);
        System.out.println(this.getServerName() + " : Cliente solicita a lista de subcomponentes da peça de ID: " + id);

        this.listSubpartOfFinancingRequest = this.listFinancingRequestRepository.get(arrayID).getSubpartsList();

        System.out.println();
        System.out.println(this.getServerName() + " : FinancingRequestRepositoryConcrete.showListOfSubparts");
        if (this.listSubpartOfFinancingRequest.size() != 0) {
            for (FinancingRequest financingRequest : this.listSubpartOfFinancingRequest) {
                System.out.println(financingRequest.getPartName());
            }
        }
    }

    /**
     * Este método retorna o id referente ao ArrayList e não ao id da peça.
     * @param id
     * @return
     */
    @Override
    public int verifyIfIDAlreadyExist(int id) throws RemoteException
    {
        int index = -1;

        for (FinancingRequest p : this.listFinancingRequestRepository) {
            if (id == p.getPartID())
                index = this.listFinancingRequestRepository.indexOf(p);
        }
        return index;
    }
}
