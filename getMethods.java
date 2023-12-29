package FirstTestCase;

import org.openqa.selenium.chrome.ChromeDriver;

public class getMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://youtube.com");
		
		Thread.sleep(5000);
		
		driver.close();		
	}

}
