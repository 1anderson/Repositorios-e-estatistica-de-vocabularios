package com.ifpb.servidor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import com.ifpb.cliente.SerialList;

@SuppressWarnings("serial")

public class InterfaceImp extends UnicastRemoteObject implements InterfaceRemota {

	 
  private String comando=null;	
  private String[] stringDividida;
  private ArrayList<String> lista;
  private InputStream in=null;
  private FileOutputStream out=null;
	 
	
	
	protected InterfaceImp() throws RemoteException {
		super();
	}

	@Override
	
	
	
	
	public void Init(SerialList lista) throws IOException {
	   this.lista=lista.getObj();
	   GitHubRepository gitHubRepository = new GitHubRepository();
	   this.Download(gitHubRepository,"url Do Projeto");//método que irá começar o Download do repositório
		   
	}

  public void Download(Repositories repository,String urlProject) throws IOException{
	  this.Extrator(repository.projectDownload(urlProject));
	  
  }

  public void Extrator(String nomeDoArquivo) throws IOException{
	
	//método que executa comandos no terminal e uso do vocabulary extractor
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






	