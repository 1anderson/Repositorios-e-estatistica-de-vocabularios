package com.ifpb.servidor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public interface Repositories {
	
	public String  projectDownload(String urlRepository) throws MalformedURLException, FileNotFoundException, IOException;

}
