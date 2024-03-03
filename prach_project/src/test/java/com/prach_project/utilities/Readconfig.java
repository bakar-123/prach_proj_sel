package com.prach_project.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class Readconfig  {

	Properties prop;
	

	public Readconfig() {
		
		String path = "C:\\Users\\kahme\\eclipse-workspace\\prach_project\\configuration\\config.properties";
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUrl() {
		String verifyurl = prop.getProperty("baseurl");

		if (verifyurl != null) {
			return verifyurl;
		} else {
			throw new RuntimeException("url is not mentioned/correct");
		}
	}

	public String getBrowser() {
		String verifybrowser = prop.getProperty("browser");

		if (verifybrowser != null) {
			return verifybrowser;
		} else {
			throw new RuntimeException("browser is not mentioned/correct");
		}
	}

}
