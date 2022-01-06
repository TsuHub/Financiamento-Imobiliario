package FinancingRequestRepositories;

public class TestRepoHandler
{
    public static void main(String[] args)
    {
        String aux = RepositoryHandler.getTxtContents("FinancingRequestRepositories/Repo S1.txt");
        System.out.println(aux);
    }
}
