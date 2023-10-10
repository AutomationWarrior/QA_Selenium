package seleniumwebdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		explicitWait = new WebDriverWait(driver, 20);
		jsExecutor = (JavascriptExecutor) driver;

		// Navigate to URL
	}

	@Test
	public void TC_01_Custom_Dropdown() {
		driver.get("https://semantic-ui.com/modules/dropdown.html");

		String parentLocator = "(//div[contains(@class,'selection')])[1]";
		String itemLocators = "(//div[contains(@class,'selection')])[1]//div[@class = 'item']";
		String expectedItem = "Female";

		selectItemInCustomDropdown(parentLocator, itemLocators, expectedItem);
		
//		// 1 - Click vào parent để list ra các item
//		WebElement dropdownGender = driver.findElement(By.xpath("(//div[contains(@class,'selection')])[1]"));
//
//		// Sroll tới parent element
//		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdownGender);
//		// Click vào parent element
//		dropdownGender.click();
//
//		sleepInSecond(5);
//
//		// 2 - Chờ cho các item dc load hết
////		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[contains(@class,'selection')])[1]//div[@class = 'item']")));
//
//		// 3 - Get các item cho vào 1 list
//		List<WebElement> allItem = driver.findElements(By.xpath("(//div[contains(@class,'selection')])[1]//div[@class = 'item']"));
//
//		// 4 - Duyệt qua list để chọn item
//		for (int i = 0; i < allItem.size(); i++) {
//			if (allItem.get(i).getText().equals("Female")) {
//				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", allItem.get(i));
//				sleepInSecond(3);
//				allItem.get(i).click();
//				sleepInSecond(3);
//				break;
//			}
//		}
	}

	public void selectItemInCustomDropdown(String parentLocator, String itemLocators, String expectedItem) {
		// 1 - Click vào parent để list ra các item
		WebElement parentElement = driver.findElement(By.xpath(parentLocator));

		// Sroll tới parent element
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", parentElement);
		// Click vào parent element
		parentElement.click();

		sleepInSecond(5);
		
		// 2 - Chờ cho các item dc load hết
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemLocators)));

		// 3 - Get các item cho vào 1 list
		List<WebElement> allItem = driver.findElements(By.xpath(itemLocators));

		// 4 - Duyệt qua list để chọn item
		for (int i = 0; i < allItem.size(); i++) {
			if (allItem.get(i).getText().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", allItem.get(i));
				sleepInSecond(3);
				allItem.get(i).click();
				sleepInSecond(3);
				break;
			}
		}
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