package com.ifpb.servidor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote; 
import java.rmi.RemoteException;
import com.ifpb.cliente.SerialList;

public interface InterfaceRemota extends Remote{
	
	 public void Init(SerialList list) throws RemoteException, 
	 FileNotFoundException, IOException;  
	 

}
