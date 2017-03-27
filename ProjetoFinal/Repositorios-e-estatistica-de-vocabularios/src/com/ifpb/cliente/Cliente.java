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
	 int novaPalavra;
	 int novaPalavra2;
	//-------------------------//
	 
	 
	 //arquivoSerializavel é uma classe serializavél //
	 ArquivoSerializavel objSerial = new ArquivoSerializavel();
	 //----------------------------------------------//
	 
	 //atribuindo o retorno do método abrindo arquivos a um array do obj da classe seralizavél//
	 objSerial.setObj(AbrindoArquivo("/home/anderson/IO.txt"));//passando o camminho do arquivo
	//---------------------------------------------------------------------------------------//	
	  
	 //chamando métodos remotos//
	  try {
		  	obj.PassaArquivos(objSerial);
	    	obj.Init();
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
 } 
     //--------------------------//	

static ArrayList<String> AbrindoArquivo(String caminho) throws IOException{
   
  ArrayList<String> listaComandos = new ArrayList<String>();
  InputStream is = new FileInputStream(caminho);
  InputStreamReader ir = new InputStreamReader(is);
  @SuppressWarnings("resource")
  BufferedReader bf = new BufferedReader(ir);
  String comando=bf.readLine();
// jogando comandos do arquivo dentro do array//
   while(comando!=null){
	   
	   listaComandos.add(comando);
	   comando=bf.readLine();
   }
//--------------------------------------------//	
	
	return listaComandos;

}

}  


	
	
	

