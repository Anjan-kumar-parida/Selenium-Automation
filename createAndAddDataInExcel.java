package FirstTestCase;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class createAndAddDataInExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\Testdata\\new2.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet();
		/*
		
		XSSFRow row1 = sheet.createRow(0);
		
		row1.createCell(1).setCellValue("a");
		row1.createCell(2).setCellValue("abcde");
		row1.createCell(3).setCellValue("pika");
		*/
		
		for(int i = 0; i < 7; i++) {
			XSSFRow currRow = sheet.createRow(i);
			
			for(int j = 0; j < 5; j++) {
				currRow.createCell(j).setCellValue(false);
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
