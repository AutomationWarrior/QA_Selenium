package seleniumwebdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Alert {
	WebDriver driver;
	ChromeOptions options;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	Alert alert;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("--ignore-certificate-errors");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		jsExecutor = (JavascriptExecutor) driver;

		// Navigate to URL
	}

//	@Test
	public void TC_01__Accept_Alert() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

		WebElement btnAlert = driver.findElement(By.xpath("//button[text() ='Click for JS Alert']"));

		btnAlert.click();

		alert = driver.switchTo().alert();

		sleepInSecond(5);

		String alertMsg = alert.getText();

		System.out.println("Alert Message: " + alertMsg);

		// Click To OK
		alert.accept();

		Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You successfully clicked an alert");

		sleepInSecond(3);
	}

//	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

		WebElement confirmAlert = driver.findElement(By.xpath("//button[text() = 'Click for JS Confirm']"));

		confirmAlert.click();

		sleepInSecond(3);

		alert = driver.switchTo().alert();

		System.out.println("Alert Message: " + alert.getText());

		// Click OK

		alert.accept();

		Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You clicked: Ok");
	}

//	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

		WebElement promptAlert = driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']"));

		promptAlert.click();

		alert = driver.switchTo().alert();

		sleepInSecond(3);

		System.out.println("Alert Message: " + alert.getText());

		alert.sendKeys("DEMO");

		sleepInSecond(5);

//		alert.accept();
		alert.dismiss();

		Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'result']")).getText(), "You entered: null");

		sleepInSecond(3);
	}

//	@Test
	public void TC_04_Basic_Auth_01() {
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		sleepInSecond(3);

		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "Congratulations! You must have the proper credentials.");
	}

	@Test
	public void TC_05_Basic_Auth_02() {
		driver.get("http://the-internet.herokuapp.com");

		String userName = "admin";
		String password = "admin";
		String basicAuthenLink = driver.findElement(By.xpath("//a[text() = 'Basic Auth']")).getAttribute("href");

//		System.out.println("Basic Authen Link: " + basicAuthenLink);
//
//		String[] basicAuthen = basicAuthenLink.split("//");
//
//		System.out.println("Basic Authen 0: " + basicAuthen[0]);
//
//		System.out.println("Basic Authen 1: " + basicAuthen[1]);
//
//		basicAuthenLink = basicAuthen[0] + "//" + userName + ":" + password + "@" + basicAuthen[1];

		driver.get(getAuthenticateLink(basicAuthenLink, userName, password));

		sleepInSecond(3);

		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "Congratulations! You must have the proper credentials.");
	}

	public String getAuthenticateLink(String url, String userName, String password) {
		String[] links = url.split("//");
		url = links[0] + "//" + userName + ":" + password + "@" + links[1];
		return url;
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