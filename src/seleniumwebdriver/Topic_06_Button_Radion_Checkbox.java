package seleniumwebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Button_Radion_Checkbox {
	WebDriver driver;
	
	ChromeOptions options;
	
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	Alert alert;

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
	}

//	@Test
	public void TC_01_Default_Not_Hidden() {
		driver.get("https://omayo.blogspot.com/");
		
		WebElement radioMale = driver.findElement(By.id("radio1"));
		
//		radioMale.click();
		
		sleepInSecond(2);
		
		// Verify radioMale is click
		Assert.assertTrue(radioMale.isSelected());
		
	}
	
//	@Test
	public void TC_02_CustomButton_Not_Hidden() {
		driver.get("https://docs.google.com/forms/d/1qFZ26rQUeGvPhoqfU6YZO0omVi0s_9EojiKx-UANhuI/viewform?edit_requested=true");
		
		WebElement btnHaNoi = driver.findElement(By.id("i5"));
		
		btnHaNoi.click();
		
		sleepInSecond(2);
		
		String statusChecked = btnHaNoi.getAttribute("aria-checked");
		
		System.out.println("Status checked: " + statusChecked);
		
		// Verify btn is selected
		Assert.assertEquals(statusChecked, "true");
	}
	
//	@Test
	public void TC_03_DefaultButton_Hidden() {
		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		
		WebElement btnDKNguoiThan = driver.findElement(By.xpath("//input[@id='mat-radio-3-input']"));
		
//		btnDKNguoiThan.click();
		jsExecutor.executeScript("arguments[0].click();", btnDKNguoiThan);
		
		sleepInSecond(5);
		
		Assert.assertTrue(btnDKNguoiThan.isSelected());
	}
	
	@Test
	public void TC_04() {
		driver.get("https://www.fahasa.com/customer/account/create");
		
		driver.findElement(By.xpath("//a[text() = 'Đăng nhập']")).click();
		
		sleepInSecond(3);
		
		WebElement ele = driver.findElement(By.xpath("//button[@class = 'fhs-btn-login']"));
		
		String color = ele.getCssValue("color");
		
		Assert.assertEquals(color, "#636363");
		
		
		System.out.println("Color: " + color);
		
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