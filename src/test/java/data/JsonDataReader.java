package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.openqa.selenium.json.Json;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class JsonDataReader
{
	String firstname , lastname , email,password;
	public void  jsonReader() throws FileNotFoundException, ParseException
	{
		String filepath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\usersdata.json";
		File srcFile = new File(filepath);
		JSONParser parser = new JSONParser(); 
		JSONArray Jarray =  (JSONArray)parser.parse(new FileReader(srcFile));
	}
}
