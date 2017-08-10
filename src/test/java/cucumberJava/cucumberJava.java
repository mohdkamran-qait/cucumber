package cucumberJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cucumberJava {

	WebDriver driver = null;

	
	
	@Given("^User navigates to qawebmail$")
	public void gotogmail() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Selenium_Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://webmail.qainfotech.com/");
		Thread.sleep(1000);
		
	}

	@When("^user logs in using Username (\\w+@?) and Password (\\w+@?\\d+)$")
	public void I_enter_Username_as_and_Password_as(String arg1, String arg2) {
		System.out.println(arg1);
		System.out.println(arg2);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(arg2);
		driver.findElement(By.xpath("//input[@class='ZLoginButton DwtButton']")).click();
	}

	@Then("^Login is successful$") 
	public void validatelogin() {
		System.out.println("Successful");
//		driver.close();

	} 
		
	


			
}