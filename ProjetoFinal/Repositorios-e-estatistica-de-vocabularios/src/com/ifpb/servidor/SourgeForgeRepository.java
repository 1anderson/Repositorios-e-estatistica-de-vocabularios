package com.ifpb.servidor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SourgeForgeRepository implements Repositories {
	private InputStream in=null;
	private FileOutputStream out=null;
	private String projectName;
	private String[] stringAuxiliar;
	
	
	public String projectDownload(String urlRepository)
			throws MalformedURLException, FileNotFoundException, IOException {
		
		int umByte=0;
	    String[] nameZip;
		
		this.projectName=urlRepository;
		this.stringAuxiliar = this.projectName.split("//"); 
		this.stringAuxiliar = this.stringAuxiliar[1].split("/",8);
		this.stringAuxiliar = this.stringAuxiliar[7].split("\\.");
		
		
		
		    URL url = new URL(urlRepository);
		    
		    in = url.openStream();  
	        out = new FileOutputStream(this.stringAuxiliar[0]+".zip");
	        
		      while ((umByte = in.read()) != -1){  
		        out.write(umByte);  
		      } 
		    
		    System.out.print("Download Terminou");
		    in.close();  
		    out.close();
		
		   this.projectName = this.stringAuxiliar[0];
		   
		   return this.projectName;
	}

}
