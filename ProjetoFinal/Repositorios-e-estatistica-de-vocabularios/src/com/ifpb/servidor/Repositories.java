package com.ifpb.servidor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public interface Repositories {
	
	public String  ProjectDownload(String UrlRepository) throws MalformedURLException, FileNotFoundException, IOException;

}
