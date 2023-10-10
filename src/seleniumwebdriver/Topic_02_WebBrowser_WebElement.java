package seleniumwebdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_WebBrowser_WebElement {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		jsExecutor = (JavascriptExecutor) driver;

		// Navigate to URL

	}

	//WebBrowser
	
//	@Test
	public void TC_01_Close_Quit() {
//		driver.get("https://demo.guru99.com/popup.php");
		driver.get("https://demo.nopcommerce.com/");
		
//		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		sleepInSecond(3);
		
//		driver.close();
		
//		driver.quit();
		
		System.out.println("Page Source: " + driver.getPageSource());
		
		String currentUrl = driver.getCurrentUrl();
		
		System.out.println("Current URL: " + currentUrl);
		
		System.out.println("Page title: " + driver.getTitle());
		
		driver.findElement(By.xpath("//ul[contains(@class,'notmobile')]//a[contains(text(),'Computers')]")).click();
		
		sleepInSecond(3);
		
		driver.navigate().back();
		
		sleepInSecond(3);
		
		driver.navigate().forward();
		
		sleepInSecond(3);
		
		driver.navigate().refresh();
	}

	// WebElement
	@Test
	public void TC_02() {
//		driver.get("https://demo.nopcommerce.com/");
		
		driver.get("https://omayo.blogspot.com/");
		
		System.out.println("Is btn1 enabled: " + driver.findElement(By.id("but1")).isEnabled());

		System.out.println("Is ckb1 selected: " + driver.findElement(By.id("checkbox1")).isSelected());

		System.out.println("Is ckb2 selected: " + driver.findElement(By.id("checkbox2")).isSelected());
		
//		WebElement txbSearch = driver.findElement(By.id("small-searchterms"));
//		
//		WebElement btnSearch = driver.findElement(By.xpath("//button[text() = 'Search']"));
//		
//		txbSearch.sendKeys("Automation");
//		
//		sleepInSecond(2);
//		
//		txbSearch.sendKeys("Automation2");
//		
//		sleepInSecond(2);
//		
//		txbSearch.clear();
//		
//		sleepInSecond(2);
		
//		String valueClass = txbSearch.getAttribute("class");
//		System.out.println("Value of class textbox Search: " + valueClass);
//		
//		String cssValueOfBtnSearch = btnSearch.getCssValue("background-color");
//		cssValueOfBtnSearch = Color.fromString(cssValueOfBtnSearch).asHex();
//		System.out.println("Background Color: " + cssValueOfBtnSearch);
//		
//		Point pointTxbSearch = txbSearch.getLocation();
//		System.out.println("Locator of txb Search: " + pointTxbSearch);
//		
//		Dimension dimensionTxbSearch = txbSearch.getSize();
//		System.out.println("Size of txb Search: " + dimensionTxbSearch);
//		
//		System.out.println("Is element displayed: " + txbSearch.isDisplayed());
		
		
	}
	
//	@Test
	public void TC_03_Verify_Value_Name() {
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.className("ico-login")).click();
		
		sleepInSecond(1);
		
		driver.findElement(By.id("Email")).sendKeys("abc123@gmail.com");
		
		sleepInSecond(1);

		driver.findElement(By.id("Password")).sendKeys("123123");
		
		sleepInSecond(1);
		
		driver.findElement(By.xpath("//button[text() ='Log in']")).click();
		
		sleepInSecond(1);
		
		driver.findElement(By.className("ico-account")).click();
		
		sleepInSecond(2);
		
		WebElement firstName = driver.findElement(By.id("FirstName"));
		
//		System.out.println("First Name: " + firstName.getText());

		System.out.println("First Name: " + firstName.getAttribute("value"));
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