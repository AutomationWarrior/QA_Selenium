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

public class Topic_07_UserAction {
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

//	@Test
	public void TC_01_DoubleClick() {
		driver.get("https://omayo.blogspot.com/");
		
		WebElement btnDoubleClick = driver.findElement(By.xpath("//button[contains(text(), 'Double click Here')]"));
		
		//Double click
		action.doubleClick(btnDoubleClick).perform();
		
		sleepInSecond(3);
		
		alert = driver.switchTo().alert();
		
		alert.accept();
		
		sleepInSecond(2);
		
	}
	
//	@Test
	public void TC_02_ClickByAction() {
		driver.get("https://omayo.blogspot.com/");
		
		WebElement btnClick = driver.findElement(By.id("alert2"));
		
//		btnClick.click();
		action.click(btnClick).perform();
		
		sleepInSecond(3);
		
		alert = driver.switchTo().alert();
		
		alert.accept();
		
		sleepInSecond(3);
		
	}
	
//	@Test
	public void TC_03_ClickAndHold() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		WebElement eleNum1 = driver.findElement(By.xpath("//li[1]"));
		
		action.clickAndHold(eleNum1).perform();
		
		String colorBackground = eleNum1.getCssValue("background");
		
		System.out.println("Color: " + colorBackground);
		
		colorBackground = colorBackground.substring(0, 17);
		
		System.out.println("Color after substring: " + colorBackground);
		
		colorBackground = Color.fromString(colorBackground).asHex();
		
		System.out.println("Color after convert to hexa: " + colorBackground);
		
		Assert.assertEquals(colorBackground, "#feca40");
		
		sleepInSecond(5);
	}
	
//	@Test
	public void TC_04_MoveToElement() {
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement eleComputer = driver.findElement(By.xpath("//ul[contains(@class,'notmobile')]//a[contains(text(), 'Computers')]"));
		
		WebElement itemDesktop = driver.findElement(By.xpath("//ul[contains(@class,'notmobile')]//a[contains(text(), 'Desktops')]"));
		
		action.moveToElement(eleComputer).perform();
		
		sleepInSecond(3);
		
		itemDesktop.click();
		
		sleepInSecond(3);
	}
	
//	@Test
	public void TC_05_ClickAndHoldMoveToElement() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		WebElement eleNum1 = driver.findElement(By.xpath("//li[1]"));
		WebElement eleNum4 = driver.findElement(By.xpath("//li[4]"));
		
		action.clickAndHold(eleNum1).moveToElement(eleNum4).perform();
		
		sleepInSecond(5);
	}
	
//	@Test
	public void TC_06_ContextClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		WebElement btnRightClick = driver.findElement(By.xpath("//span[text() = 'right click me']"));
		
		action.contextClick(btnRightClick).perform();
		
		sleepInSecond(3);
		
		WebElement itemEdit = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-edit')]"));
		
		itemEdit.click();
		
		sleepInSecond(3);
	}
	
//	@Test
	public void TC_07_DragDrop() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		
		WebElement smallCircle = driver.findElement(By.id("draggable"));
		
		WebElement bigCircle = driver.findElement(By.id("droptarget"));
		
		action.dragAndDrop(smallCircle, bigCircle).perform();
		
		sleepInSecond(5);
		
		Assert.assertEquals(bigCircle.getText(), "You did great!");
	}
	
//	@Test
	public void TC_08_KeyDownKeyUp() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		
		List<WebElement> allNums = driver.findElements(By.tagName("li"));

//		action.keyDown(Keys.CONTROL).clickAndHold(allNums.get(0))
//									.moveToElement(allNums.get(3))
//									.release()
//									.perform();
		
		action.keyDown(Keys.CONTROL)
			  .click(allNums.get(0))
			  .click(allNums.get(6))
			  .click(allNums.get(8))
			 .keyUp(Keys.CONTROL)
			 .perform();
		
		sleepInSecond(5);
	}
	
	@Test
	public void TC_09_SendKeys() {
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement txbSearch = driver.findElement(By.id("small-searchterms"));
		
		action.sendKeys(txbSearch, "mac").sendKeys(Keys.ENTER).perform();
		
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