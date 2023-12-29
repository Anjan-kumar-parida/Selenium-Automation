package FirstTestCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class fixedDepositCalculator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		JavascriptExecutor js = driver;
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		String filePath = System.getProperty("user.dir") + "\\Testdata\\caldata.xlsx";
		
		int row = excelUtils.getRowCount(filePath, "Sheet1");
		
		
		for(int i = 1; i <= row; i++) {
			
			//getting the data
			String principal = excelUtils.getCellData(filePath, "Sheet1", i, 0);
			String roi = excelUtils.getCellData(filePath, "Sheet1", i, 1);
			String period1 = excelUtils.getCellData(filePath, "Sheet1", i, 2);
			String period2 = excelUtils.getCellData(filePath, "Sheet1", i, 3);
			String frequency = excelUtils.getCellData(filePath, "Sheet1", i, 4);
			String expec_return = excelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			driver.findElement(By.xpath("//*[@id=\"principal\"]")).sendKeys(principal);
			driver.findElement(By.xpath("//*[@id=\"interest\"]")).sendKeys(roi);
			driver.findElement(By.xpath("//*[@id=\"tenure\"]")).sendKeys(period1);
			
			Select timeInterval = new Select(driver.findElement(By.xpath("//*[@id=\"tenurePeriod\"]")));
			timeInterval.selectByVisibleText(period2);
			
			Select frequencyType = new Select(driver.findElement(By.xpath("//*[@id=\"frequency\"]")));
			frequencyType.selectByVisibleText(frequency);
			
			WebElement clickBtn = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]"));
			WebElement clearBtn = driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]"));
			
			js.executeScript("arguments[0].click", clickBtn);
			
			String act_return = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]//strong")).getText();
			
			
			System.out.println(expec_return + " " + act_return);
			
			
			if(Double.parseDouble(act_return) == Double.parseDouble(expec_return)) {
				excelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				excelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			}else {
				excelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				excelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			
			js.executeScript("arguments[0].click", clearBtn);
			
			
		}
		
		
	}

}
