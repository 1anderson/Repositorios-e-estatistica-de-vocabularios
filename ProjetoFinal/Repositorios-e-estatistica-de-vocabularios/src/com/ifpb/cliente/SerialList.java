package com.ifpb.cliente;

import java.io.Serializable;
import java.util.ArrayList;

//classe serializavél//
public class SerialList implements  Serializable {


	private static final long serialVersionUID = 1L;
ArrayList<String> obj = new ArrayList<String>();


public ArrayList<String> getObj() {
	return obj;
}

public void setObj(ArrayList<String> obj) {
	this.obj = obj;
}


}