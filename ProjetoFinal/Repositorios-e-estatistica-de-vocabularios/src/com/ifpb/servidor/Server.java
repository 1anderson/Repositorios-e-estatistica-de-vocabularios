package com.ifpb.servidor;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException{
         
    InterfaceRemota m = new InterfaceImp(); 
    Registry registro=LocateRegistry.createRegistry(1099);
    registro.bind("RMI", m);
	
	}
	
}