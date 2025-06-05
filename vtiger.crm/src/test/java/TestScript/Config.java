package TestScript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
  
	public static void main(String[] args) throws IOException {
		
	FileInputStream source = new FileInputStream("C:\\Users\\Sarvesh\\OneDrive\\Desktop\\javaworkspace\\vtiger.crm\\src\\test\\resources\\config1.properties");
	Properties pro= new Properties();
	pro.load(source);
	System.out.println(pro.getProperty("username"));
	
	
	
	}

}
