package com.ifpb.servidor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException{
         
    InterfaceRemota servidor = new InterfaceImp(); 
    Registry registro=LocateRegistry.createRegistry(7000);
    registro.bind("RMI", servidor);
	
	}
	
}