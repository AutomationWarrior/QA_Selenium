package seleniumwebdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_FixPopUp {
	WebDriver driver;
	
	ChromeOptions options;
	
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	Alert alert;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		
		options = new ChromeOptions();
		
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		jsExecutor = (JavascriptExecutor)driver;
		
		action = new Actions(driver);
	}

	@Test
	public void TC_01_NgoaiNgu24h_FixedPopUp() {
		driver.get("https://ngoaingu24h.vn/");
		
		WebElement btnLogin = driver.findElement(By.xpath("//div[@id ='button-login-dialog']//button[contains(@class,'login')]"));
		
		WebElement txbUserName = driver.findElement(By.xpath("(//div[@id ='modal-login-v1']//input[@id = 'account-input'])[1]"));

		WebElement txbPassword = driver.findElement(By.xpath("(//div[@id ='modal-login-v1']//input[@id = 'password-input'])[1]"));
		
		btnLogin.click();
		
		sleepInSecond(2);
		
		txbUserName.sendKeys("username1");
		txbPassword.sendKeys("password1");
		
		sleepInSecond(3);
		
	}
	

	

	public void sleepInSecond(int timeOut) {
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}