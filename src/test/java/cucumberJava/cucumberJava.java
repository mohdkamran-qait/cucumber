package cucumberJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cucumberJava {

	WebDriver driver = null;

	@Given("^user initiate the driver$")
	public void initdriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Selenium_Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Given("^User navigates to qawebmail$")
	public void gotogmail() throws InterruptedException {
		
		driver.get("https://webmail.qainfotech.com/");
		Thread.sleep(1000);

	}

	@When("^user logs in using Username (\\w+@?) and Password (\\w+@?\\d+)$")
	public void I_enter_Username_as_and_Password_as(String arg1, String arg2) throws InterruptedException {
		System.out.println(arg1);
		System.out.println(arg2);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(arg2);
		driver.findElement(By.xpath("//input[@class='ZLoginButton DwtButton']")).click();
		Thread.sleep(2000);
	}

	@Then("^Login is successful$")
	public void validatelogin() {
		System.out.println("Successful");
		// driver.close();

	}

	@Given("^user clicks compose button$")
	public void click_compose_button() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@id='zb__NEW_MENU']//td[@id='zb__NEW_MENU_title'][text()='New Message']"))
				.click();
	}

	@When("^user will edit message$")
	public void edit_message() {
		driver.findElement(By.xpath("//input[@id='zv__COMPOSE-1_to_control']")).sendKeys("mohdkamranqait@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'zv__COMPOSE-1_subject_control']")).sendKeys("CucumberTest");
		driver.switchTo().frame("ZmHtmlEditor1_body_ifr");
		driver.findElement(By.xpath("")).sendKeys("Helllloooo!!!!!");

	}

	@When("^user will click send button$")
	public void send_message() {
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//body[@aria-label ='Compose body']")).click();
	}

	@Then("^message is send$")
	public void msg_success() {
		System.out.println("Message is sent successfully!!!!!!!!!!!!!!!!!!!");
	}

}