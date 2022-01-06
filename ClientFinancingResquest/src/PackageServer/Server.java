package PackageServer;

import ServerAPIs.FinancingRequestRepositoryConcrete;

public class Server
{
    private int serverID;
    private String serverName;
    private FinancingRequestRepositoryConcrete repository;

    public Server(int id, String name, FinancingRequestRepositoryConcrete repository) {
        this.serverID = id;
        this.serverName = name;
        this.repository = repository;
    }

    public int getServerID(){
        return this.serverID;
    }

    public String getServerName(){
        return this.serverName;
    }

    public FinancingRequestRepositoryConcrete getRepository(){
        return this.repository;
    }
}
