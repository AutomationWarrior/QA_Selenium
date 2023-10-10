package seleniumwebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_TextBox_TextArea {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		jsExecutor = (JavascriptExecutor)driver;

		// Navigate to URL
	}

//	@Test
	public void TC_01_Textbox() {
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement txbSearchStore = driver.findElement(By.id("small-searchterms"));
		
		// SendKeys
		txbSearchStore.sendKeys("Apple MacBook Pro 13-inch");
	
		sleepInSecond(5);
		
		// Clear
		
		txbSearchStore.clear();
		
		sleepInSecond(5);
	}
	
	@Test
	public void TC_02_TextArea() {
		driver.get("https://omayo.blogspot.com/");
		
		WebElement txaElement = driver.findElement(By.xpath("//textarea[@id ='ta1']"));
		

		txaElement.sendKeys("Automation1\nAutomation2\nAutomation3");
		
		sleepInSecond(3);
		
		
		WebElement txaElement2 = driver.findElement(By.xpath("//h2[text() = 'Text Area Field Two']//parent::div[@id = 'HTML11']//textarea"));
		
		System.out.println("Text: " + txaElement2.getText());
		
		WebElement txbReadOnly = driver.findElement(By.id("rotb"));
		
		System.out.println("Text from read only textbox: " + txbReadOnly.getAttribute("value"));
		
		WebElement txbDisabled = driver.findElement(By.id("tb2"));
		
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", txbDisabled);
		
		txbDisabled.sendKeys("Demo");
		
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