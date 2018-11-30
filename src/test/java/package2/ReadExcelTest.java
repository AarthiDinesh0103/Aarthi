package package2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelTest {
	

	@Test
	public void readData() throws Exception{
		File file = new File("C:\\Users\\Dinesh\\workspace\\myApplication\\src\\test\\resources\\InputExcelData.xlsx");
		FileInputStream in = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(in);
		Sheet sh = wb.getSheet("Sheet1");
		 for(int i=0;i<sh.getPhysicalNumberOfRows();i++){		 
			 Row eachrow = sh.getRow(i);
			 for(int j=0;j<eachrow.getPhysicalNumberOfCells();j++){
			 Cell cell = eachrow.getCell(j);
			 
			 if(cell.getCellType()== 0){
				 System.out.println(cell.getNumericCellValue());
		 }else if(cell.getCellType()== 1){
			 System.out.println(cell.getStringCellValue());
		 }
	        }
            }
}
}
