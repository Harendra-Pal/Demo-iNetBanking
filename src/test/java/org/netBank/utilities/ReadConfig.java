package org.netBank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is : " +e.getMessage());
		}
	
	}
	public String getvalue(String str) {
		String value = pro.getProperty(str);
		return value;
	}
}