package com.ifpb.cliente;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import com.ifpb.servidor.InterfaceRemota;

public class Cliente {
	
	
 public static void main( String args[] ) throws NotBoundException, FileNotFoundException, IOException {
    // criação da comunicação //
	 Registry registro = LocateRegistry.getRegistry("localhost",1099);
	 InterfaceRemota obj=(InterfaceRemota) registro.lookup("RMI");
	//-------------------------//
	 
	 
	 //arquivoSerializavel é uma classe serializavél //
	 SerialList ListSerialized = new SerialList();
	 //----------------------------------------------//
	 
	 //atribuindo o retorno do método abrindo arquivos a um array do obj da classe seralizavél//
	 ListSerialized.setObj(openArquive("/home/anderson/IO.txt"));//passando o camminho do arquivo
	//---------------------------------------------------------------------------------------//	
	  
	 //chamando métodos remotos//
	  try {
		  	
	    	obj.Init(ListSerialized);
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
 } 
     //--------------------------//	

static ArrayList<String> openArquive(String destiny) throws IOException{
   
  ArrayList<String> listOfUrls = new ArrayList<String>();
  InputStream is = new FileInputStream(destiny);
  InputStreamReader ir = new InputStreamReader(is);
  @SuppressWarnings("resource")
  BufferedReader bf = new BufferedReader(ir);
  String line=bf.readLine();

   while(line!=null){
	   listOfUrls.add(line);
	   line=bf.readLine();
   }
   return listOfUrls;

}

}  


	
	
	

