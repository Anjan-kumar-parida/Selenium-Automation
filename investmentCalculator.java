package FirstTestCase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class investmentCalculator {
	public static void main(String []args) throws IOException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		
		String filePath = System.getProperty("user.dir") + "\\Testdata\\caldata2.xlsx";
		int rows = excelUtils.getRowCount(filePath, "Sheet1");
		
		
		
		
		for(int i = 1; i <= rows; i++) {
			String initialAmount = excelUtils.getCellData(filePath, "Sheet1", i, 0);
			String duration = excelUtils.getCellData(filePath, "Sheet1", i, 2);
			String ROI = excelUtils.getCellData(filePath, "Sheet1", i, 1);
			String compoundPeriod = excelUtils.getCellData(filePath, "Sheet1", i, 3);
			String expecReturn = excelUtils.getCellData(filePath, "Sheet1", i, 4);
			
			WebElement inputDeposit = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
			WebElement inputDuration = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
			WebElement inputROI = driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]"));
			
			inputDeposit.clear();
			inputDeposit.sendKeys(initialAmount);
			
			inputDuration.clear();
			inputDuration.sendKeys(duration);
			
			inputROI.clear();
			inputROI.sendKeys(ROI);
			
			
			List<WebElement> compoundList = driver.findElements(By.xpath("//*[@id=\"mat-select-0-panel\"]//mat-option"));
			
			for(WebElement x : compoundList) {
				if(x.getText().equals(compoundPeriod)) {
					x.click();
					break;
				}
			}
			
			driver.findElement(By.xpath("//*[@id=\"CIT-chart-submit\"]/div")).click();
			
			String actReturn = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tr[1]/td[3]/p")).getText();
			
			if(Double.parseDouble(actReturn) == Double.parseDouble(expecReturn)) {
				excelUtils.setCellData(filePath, "Sheet1", i, 6, "Pass");
			}else {
				excelUtils.setCellData(filePath, "Sheet1", i, 6, "Fail");
			}
			
		}
	}
}
