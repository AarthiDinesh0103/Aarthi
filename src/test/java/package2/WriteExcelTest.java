package package2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelTest {
	
	
	@Test
	public void testExcelWrite()throws IOException{
		File location = new File("C:\\Users\\Dinesh\\workspace\\myApplication\\src\\test\\resources\\InputExcelData.xlsx");
		FileInputStream reader = new FileInputStream(location);
		Workbook wb = new XSSFWorkbook(reader);
		Sheet sheet = wb.getSheet("Sheet1");
		int row = 2;
		int col = 3;	 
			 Row rows = sheet.getRow(row);
			 if(rows == null){
				 sheet.createRow(row);
			 }
			 Cell currentcell = sheet.getRow(row).getCell(col);
				 if(currentcell == null ){
					 sheet.getRow(row).createCell(col).setCellValue("New String");
		 }else {
			 sheet.getRow(row).getCell(col).setCellValue("New String");
		 }
				 FileOutputStream out = new FileOutputStream("C:\\Users\\Dinesh\\workspace\\myApplication\\src\\test\\resources\\InputExcelData.xlsx");
				 wb.write(out);
				 out.close();
	        }
            }




