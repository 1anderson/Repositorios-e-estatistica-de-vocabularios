package com.ifpb.servidor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class GitHubRepository implements Repositories {

	private InputStream in=null;
	private FileOutputStream out=null;
	private URL connectionToTheRepository=null;
	private String projectName;
	private String[] stringAuxiliar;
	
	public String ProjectDownload(String linkRepository) throws IOException {
			int umByte = 0;
			this.projectName = linkRepository;
			this.stringAuxiliar = this.projectName.split("//");
			this.stringAuxiliar = this.stringAuxiliar[1].split("/",4);
			this.connectionToTheRepository = new URL(this.projectName);
			this.in = this.connectionToTheRepository.openStream();  
	        out = new FileOutputStream(this.stringAuxiliar[2]+".zip");
	        System.out.println("Baixando o arquivo da url : \n"+this.projectName);
	        this.projectName = this.stringAuxiliar[2];
	        while ((umByte = in.read()) != -1){  
		        out.write(umByte);  
		    } 
	        System.out.print("Download Terminou");
		    this.in.close();  
		    this.out.close();
		
		    return this.projectName;
		
		
	}

}
