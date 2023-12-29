package FirstTestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://the-internet.herokuapp.com/iframe");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).clear();
		driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys("Anjan");
		
	}

}
