package FirstTestCase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelApache {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Testdata\\data.xlsx");
		
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		for(int i = 0; i <= rows; i++) {
			XSSFRow currRow = sheet.getRow(i);
			for(int j = 0; j < cols; j++) {
				String str = currRow.getCell(j).toString();
				System.out.print(str + "	");
			}
			System.out.println();
		}
		
	}

}
