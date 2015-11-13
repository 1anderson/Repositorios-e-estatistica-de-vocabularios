package com.ifpb.servidor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote; 
import java.rmi.RemoteException;
import com.ifpb.cliente.ArquivoSerializavel;

public interface InterfaceRemota extends Remote{
	
	 public void Init() throws RemoteException, 
	 FileNotFoundException, IOException;  
	 public void PassaArquivos(ArquivoSerializavel file) throws RemoteException;

}
