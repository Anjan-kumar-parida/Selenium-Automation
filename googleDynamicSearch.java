package FirstTestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleDynamicSearch {
	public static void main(String []args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("pokemon");	
		
		Thread.sleep(1000);
		
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul/li"));
		
		for(WebElement x: list) {
			if(x.getText().contains("FireRed and LeafGreen")) {
				System.out.println("yes");
				x.click();
				break;
			}
			
			//System.out.println(x.getText());
			
		}
	}
}
