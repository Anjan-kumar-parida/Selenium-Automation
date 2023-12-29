package FirstTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class nopCommerceLoginAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		Thread.sleep(1000);
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement username = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		username.clear();
		username.sendKeys("admin@yourstore.com");
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		password.clear();
		password.sendKeys("admin8");
		
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		
		
		String title = "";
		String act_title = "Dashboard / nopCommerce administration";
		try {
			title = driver.getTitle();
			}catch(Exception e) {
			
		}
		
		if(title.equals(act_title)) {
			System.out.println("Correct");
		}else System.out.println("Incorrect");
		
	}

}
