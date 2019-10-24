package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
	public  static Properties userdata= loadProperties (System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties"); 
	private static Properties loadProperties (String path)
	{
		Properties pro = new Properties();
		try 
		{
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR ocured ...  "+e.getMessage());
		} catch (IOException e) 
		{
			System.out.println("ERROR ocured ...  "+e.getMessage());
		}
		return pro;
	}

}
