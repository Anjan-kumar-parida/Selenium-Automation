package FirstTestCase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class swithchingBetweenBrowserWWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//searched
		driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-input\"]")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-form\"]/div/span[2]/span[2]/input")).click();
		
		//opening sites
		
		List<WebElement> siteList = driver.findElements(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-results\"]//a"));
		
		for(WebElement x : siteList) {
			x.click();
			
		}
		
		//capturing the windowID of every window
		
		Set<String> WindowID = driver.getWindowHandles();
		
		for(String x : WindowID) {
			String str = driver.switchTo().window(x).getTitle();
			System.out.println(str);
		}
		
		driver.quit();
		
	}

}
