package utilites;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.BaseClass;

public class ReadExcel extends BaseClass {
	
	public String[][] readExcel(String fileName) throws IOException{
		
		XSSFWorkbook wb = new XSSFWorkbook("./Data/"+fileName+".xlsx");
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowCount = ws.getLastRowNum();
		
		int cellCount = ws.getRow(0).getLastCellNum();
		
		ws.getPhysicalNumberOfRows();
		
		System.out.println(ws.getPhysicalNumberOfRows());
		
		String[][] data = new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			
			for (int j = 0; j < cellCount; j++) {
				
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				
				data[i-1][j] = 	cellValue;		
			}
			
		}
		
		wb.close();
		return data;
	}
	
	

}
