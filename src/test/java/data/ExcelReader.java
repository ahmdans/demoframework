package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	static FileInputStream FIS = null ; 
	public FileInputStream GetFileInputStream()
	{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\USERdata.xlsx";
		File srcfile = new File (filePath);
		try 
		{
			FIS= new FileInputStream(srcfile);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("feen l file ya prince  ...  "+e.getMessage());
			System.exit(0);
		}
		return  FIS;
	}
	public Object [][] Getexceldata() throws IOException
	{ 
		FIS= GetFileInputStream();
		XSSFWorkbook Wb=new XSSFWorkbook(FIS);
		XSSFSheet sheet=  Wb.getSheetAt(0);
		int totalnumberofrows = (sheet.getLastRowNum()+1 ); 
		int totalnumberofcul  = 4;

		String [][] arrayofexcel = new String  [totalnumberofrows][totalnumberofcul];
		for (int i = 0; i < totalnumberofrows; i++)
		{
			for (int j = 0; j < totalnumberofcul ; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				arrayofexcel [i] [j]= row.getCell(j).toString();
			}
		} 
		Wb.close();
		return arrayofexcel ; 
	}
}
