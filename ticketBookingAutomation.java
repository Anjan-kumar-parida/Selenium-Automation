package FirstTestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ticketBookingAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//firstname and lastname
		
		driver.findElement(By.xpath("//*[@id=\"travname\"]")).sendKeys("Anjan");
		driver.findElement(By.xpath("//*[@id=\"travlastname\"]")).sendKeys("Parida");
		
		//dob
		//month
		
		
		driver.findElement(By.xpath("//*[@id=\"dob\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]")).click();
		List<WebElement> months = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]/option"));
		
		for(WebElement x : months) {
			if(x.getText().equals("Sep")) {
				x.click();
				break;
			}
			
		}
		
		//year
		
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]")).click();
		List<WebElement> years = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]/option"));
		
		for(WebElement x: years) {
			if(x.getText().equals("1999")) {
				x.click();
				break;
			}
		}
		
		//date
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]")).click();
		
		/*List<WebElement> dates = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody//tr/td"));
		
		String date = "17";
		
		
		for(WebElement x: dates) {
			if(x.getText().equals(date)) {
				x.click();
				break;
			}
			System.out.println(x.getText());
		}
		
		System.out.println(dates.size());
		*/
		
		
		//gender
		
		driver.findElement(By.xpath("//*[@id=\"sex_1\"]")).click();
		
		//address
		
		driver.findElement(By.xpath("//*[@id=\"fromcity\"]")).sendKeys("abc");
		driver.findElement(By.xpath("//*[@id=\"tocity\"]")).sendKeys("abc");
		
		//departure date
		
		driver.findElement(By.xpath("//*[@id=\"departon\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")).click();		
		
		//detailed address
		
		driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("House no-25,baripada");
		driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("Baripada");
		driver.findElement(By.xpath("//*[@id=\"billing_state_field\"]/span/span/span[1]/span/span[2]")).click();
		
		List<WebElement> stateList = driver.findElements(By.xpath("//*[@id=\"select2-billing_state-results\"]/li"));
		
		for(WebElement x : stateList) {
			if(x.getText().equals("Odisha")) {
				x.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("757001");
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();
	}

}
