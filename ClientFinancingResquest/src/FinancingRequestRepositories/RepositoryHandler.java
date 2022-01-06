package FinancingRequestRepositories;

import ServerAPIs.FinancingRequest;
import ServerAPIs.FinancingRequestConcrete;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A estrutura do arquivo é: id;nome;descrição
 */

public class RepositoryHandler
{
    public static void initializeRepositoryTxt(String fileRepoName, ArrayList<FinancingRequest> financingRequestArrayList)
    {
        int id;
        String nome;
        String description;

        String path = "FinancingRequestRepositories/" + fileRepoName + ".txt";

        try
        {
            File objTxt = new File(path);
            Scanner reader = new Scanner(objTxt);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Scanner lineScan = new Scanner(line).useDelimiter(";");

                id = lineScan.nextInt();
                nome = lineScan.next();
                description = lineScan.next();

                financingRequestArrayList.add(new FinancingRequestConcrete(id, nome, description));
                //System.out.printf("ID: %d    Nome: %s    Descrição: %s\n", id, nome, description);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getTxtContents(String fileName)
    {
        String contents = "";
        String line = "";

        String path = fileName;
        File objTxt = new File(path);

        try
        {
            Scanner reader = new Scanner(objTxt);
            if (reader.hasNextLine()) contents = reader.nextLine();

            while (reader.hasNextLine()) {
                line = reader.nextLine();
                contents = contents + "\n" + line;
            }
            System.out.println(contents);

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return contents;
    }

    public static void addPartToRepoTxt(String fileRepoName, FinancingRequest financingRequest) throws RemoteException
    {
        String path = "FinancingRequestRepositories/" + fileRepoName + ".txt";
        String cont = getTxtContents(path);
        String registry = financingRequest.getPartID() + ";" + financingRequest.getPartName() + ";" + financingRequest.getPartDescriptions();

        try
        {
            FileWriter objTxt = new FileWriter(path);
            PrintWriter pw = new PrintWriter(objTxt);

            if (cont.equals("")) pw.print(registry);
            else {
                cont = cont + "\n" + registry;
                pw.print(cont);
            }
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removePartRepoTxt(String fileRepoName, int idToRemove)
    {
        String path = "FinancingRequestRepositories/" + fileRepoName + ".txt";
        String contents = "";
        int id;

        try
        {
            File objTxt = new File(path);
            Scanner reader = new Scanner(objTxt);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Scanner lineScan = new Scanner(line).useDelimiter(";");

                id = lineScan.nextInt();

                if (!(id == idToRemove)) {
                    if (contents.equals("")) contents = line;
                    else contents = contents + "\n" + line;
                }
            }
            reader.close();

            File newObjTxt = new File(path);
            PrintWriter pw = new PrintWriter(newObjTxt);
            pw.append(contents);

            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
