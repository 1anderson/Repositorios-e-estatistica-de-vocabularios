package com.ifpb.servidor;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import com.ifpb.cliente.SerialList;

@SuppressWarnings("serial")

public class InterfaceImp extends UnicastRemoteObject implements InterfaceRemota {

	private ArrayList<String> lista;
  
	protected InterfaceImp() throws RemoteException {
		super();
	}

	@Override
	public void Init(SerialList lista) throws IOException {
	   this.lista=lista.getObj();
	   GitHubRepository gitHubRepository = new GitHubRepository();
	   this.Download(gitHubRepository,this.lista.get(0));
		   
	}

	public void Download(Repositories repository,String urlProject) throws IOException{
	  this.Extrator(repository.projectDownload(urlProject));
	  
	}

    public void Extrator(String nomeDoArquivo) throws IOException{
	  String line="mkdir "+nomeDoArquivo+"-v-e";
      CommandLine cmdLine = CommandLine.parse(line);
      DefaultExecutor executor = new DefaultExecutor();
      executor.execute(cmdLine);
      line="unzip "+nomeDoArquivo+".zip -d ./";
      cmdLine = CommandLine.parse(line);
      executor.execute(cmdLine);
      String extrator = "java -jar VocabularyExtractor.jar -n \"termscounter\" -d \"./"+nomeDoArquivo+"-master/\" -loc iah -vxl \"./"+nomeDoArquivo+"-v-e/termscounter.vxl\" -csv \"./"+nomeDoArquivo+"-v-e/termscounter.csv\"";
      cmdLine = CommandLine.parse(extrator);
      executor.execute(cmdLine);
      line="rm -rf "+nomeDoArquivo+"-master";
      cmdLine = CommandLine.parse(line);
      executor.execute(cmdLine);
      line="rm -rf "+nomeDoArquivo+".zip";
      cmdLine = CommandLine.parse(line);
      executor.execute(cmdLine);

    }



}






	