package FirstTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDropAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		//source
		
		WebElement bank = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		WebElement sales = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		WebElement first_5 = driver.findElement(By.xpath("//*[@id=\"fourth\"][1]"));
		WebElement second_5 = driver.findElement(By.xpath("//*[@id=\"fourth\"][2]"));
		
		
		//destination
		
		WebElement debitAccount = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		WebElement debitAmount = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		WebElement creditAccount = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		WebElement creditAmount = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		
		
		Actions act = new Actions(driver);
		act.dragAndDrop(bank,debitAccount).perform();
		act.dragAndDrop(first_5, debitAmount).perform();
		act.dragAndDrop(sales, creditAccount).perform();
		act.dragAndDrop(second_5, creditAmount).perform();
	}

}
