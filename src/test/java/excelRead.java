import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelRead 
{
@Test
	public void excelRead_TestData() throws IOException
	{
		String excelFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\cv_TestData.xlsx";
				
		FileInputStream Fis = new FileInputStream(excelFilePath);
		
		XSSFWorkbook wb = new XSSFWorkbook(Fis);
		
		XSSFSheet sheet = wb.getSheet("loginData");
		
		int row = sheet.getLastRowNum();
		
		int cell = sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of rows "+row+" and Number of cells are "+cell);
		
		
		Object ob[][] = new Object[row][cell];
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
