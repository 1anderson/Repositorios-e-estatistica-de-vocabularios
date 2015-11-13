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
import com.ifpb.cliente.ArquivoSerializavel;

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
	public void Init() throws IOException {
		
	   this.Download();//método que irá começar o Download do repositório
		   
	}

  public void Download() throws IOException{
//Lendo o vetor com a url's e  fazendo o download	
    int umByte = 0;
	  for(int i=0;i<lista.size();i++){
		comando=lista.get(i);
		stringDividida =comando.split("//");
		System.out.println("Baixando o arquivo da url : \n"+comando);
		stringDividida=stringDividida[1].split("/",4);
	    URL url = new URL(comando);
	    in = url.openStream();  
        out = new FileOutputStream(stringDividida[2]+".zip");
		  
	      while ((umByte = in.read()) != -1){  
	        out.write(umByte);  
	      } 
	    
	    System.out.print("Download Terminou");
	    in.close();  
	    out.close();
	    this.Extrator(stringDividida[2]);//chamando o método que executa o vocabulary Extractor
	    umByte=0;
	
	  }
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

  public void PassaArquivos(ArquivoSerializavel file) throws RemoteException {
	// método para receber o obj serializavél do cliente 
	lista=file.getObj();
	
}

}






	