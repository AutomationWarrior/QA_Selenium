package seleniumwebdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Default_Dropdown {
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

//	@Test
	public void TC_01_Default_Dropdown() {
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		WebElement dropdownDay = driver.findElement(By.name("DateOfBirthDay"));
		WebElement dropdownMonth = driver.findElement(By.name("DateOfBirthMonth"));
		WebElement dropdownYear = driver.findElement(By.name("DateOfBirthYear"));
		
//		dropdownDay.click();
//		
//		sleepInSecond(2);
//		
//		WebElement item15 = driver.findElement(By.xpath("//option[text() = '15']"));
//		
//		item15.click();
//		
//		sleepInSecond(5);
		
		Select selectDay = new Select(dropdownDay);
		
		Select selectMonth = new Select(dropdownMonth);
		
		Select selectYear = new Select(dropdownYear);
		
		// Select
		
		selectMonth.selectByValue("3"); //March
		
		sleepInSecond(5);
		
		WebElement itemMarch =  selectMonth.getFirstSelectedOption();
		
		System.out.println("Item March: " + itemMarch.getText());
		
		Assert.assertEquals(itemMarch.getText(), "March");
		
		System.out.println("Is multiple: " + selectMonth.isMultiple());

	}
	
//	@Test
	public void TC_02_Default_Dropdown() {
		driver.get("https://omayo.blogspot.com/");
		
		Select selectCar = new Select(driver.findElement(By.id("multiselect1")));
		
		selectCar.selectByVisibleText("Volvo");
		selectCar.selectByVisibleText("Audi");
		selectCar.selectByVisibleText("Swift");
		
		sleepInSecond(5);
		
		List<WebElement> allSelectedOptions = selectCar.getAllSelectedOptions();
		
		for(int i = 0; i < allSelectedOptions.size(); i++) {
			System.out.println(allSelectedOptions.get(i).getText());
		}
		
		System.out.println("Is multiple: " + selectCar.isMultiple());
		
	}

	@Test
	public void TC_03() {
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		
		Select selectGender = new Select(driver.findElement(By.xpath("(//div[contains(@class,'selection')])[1]")));
		
		selectGender.selectByVisibleText("Female");
		
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