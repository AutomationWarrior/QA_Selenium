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

public class Topic_08_RandomPopUp {
	WebDriver driver;
	
	ChromeOptions options;
	
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	Alert alert;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		
//		options = new ChromeOptions();
//		
//		options.addArguments("--ignore-ssl-errors=yes");
//		options.addArguments("--ignore-certificate-errors");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		jsExecutor = (JavascriptExecutor)driver;
		
		action = new Actions(driver);
	}

//	@Test
	public void TC_01_RandomPopUp() {
		driver.get("https://vnk.edu.vn/");
		
		sleepInSecond(31);
		
		// Ktra xem popup có hiển thị hay ko?
		if(driver.findElement(By.cssSelector("#tve_editor")).isDisplayed()) {
			// Tắt popup
//			driver.findElement(By.xpath("//div[contains(@class,'tcb-icon-display')]")).click();
			
			action.click(driver.findElement(By.xpath("//div[contains(@class,'tcb-icon-display')]"))).perform();
			
			sleepInSecond(2);
		}
		
		driver.findElement(By.xpath("//li[@id='menu-item-33246']//a[text() ='Trở thành giảng viên VNK']")).click();
		
		sleepInSecond(3);
	}
	
//	@Test
	public void TC_02_RandomPopUP_In_DOM() {
		driver.get("https://www.kmplayer.com/home");
		
		sleepInSecond(5);
		
		if(driver.findElement(By.xpath("//div[@id ='layer2']")).isDisplayed()) {
			//Close popup
//			driver.findElement(By.id("btn-r")).click();
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.id("btn-r")));
			
			sleepInSecond(2);
			
			// Verify popup ko hiển thị
			Assert.assertFalse(driver.findElement(By.xpath("//div[@id ='layer2']")).isDisplayed());
		}
		
		driver.findElement(By.xpath("//a[text() ='KMPlex']")).click();
		
		sleepInSecond(5);
	}
	
	@Test
	public void TC_03_RandomPopUp_Not_In_DOM() {
		driver.get("https://www.southernlabware.com/");
		
		sleepInSecond(10);
		
		By locatorPopUp = By.xpath("//div[@id = 'targetbay_modal']");
		By locatorButtonClose = By.xpath("//button[@aria-label = 'Close']");
		By locatorMenuSubscribeSave = By.xpath("//a[text() = 'Subscribe & Save']");
		
		if(driver.findElement(locatorPopUp).isDisplayed()) {
			driver.findElement(locatorButtonClose).click();
			
			sleepInSecond(2);
			
			List<WebElement> allItems = driver.findElements(locatorPopUp);
			
			//Verify popup ko hiển thị nữa
			Assert.assertEquals(0, allItems.size());
			
			
//			Assert.assertFalse(driver.findElement(locatorPopUp).isDisplayed());
		}
		
		driver.findElement(locatorMenuSubscribeSave).click();
		
		sleepInSecond(5);
		
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