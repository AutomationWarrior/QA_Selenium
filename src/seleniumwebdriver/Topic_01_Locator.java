package seleniumwebdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Locator {
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
	public void TC_01_FB() {
		driver.get("https://www.facebook.com/");
		// ID
		System.out.println("Before ID");
		driver.findElement(By.id("email"));
		System.out.println("After ID");

		// CLASS
		System.out.println("Before CLASS");
		driver.findElement(By.className("_sv4"));
		System.out.println("After CLASS");

		// NAME
		System.out.println("Before NAME");
		driver.findElement(By.name("pass"));
		System.out.println("After NAME");

		// LINK TEXT
		System.out.println("Before LINK TEXT");
		driver.findElement(By.linkText("Tiếng Việt"));
		System.out.println("After LINK TEXT");

		// PARTIAL LINK TEXT
		System.out.println("Before PARTIAL LINK TEXT");
		driver.findElement(By.partialLinkText("Việt"));
		System.out.println("After PARTIAL LINK TEXT");

		// TAG NAME
		System.out.println("Before TAG NAME");
		driver.findElement(By.tagName("input"));
		System.out.println("After TAG NAME");

		// Xpath
		System.out.println("Before Xpath");
		driver.findElement(By.xpath("//button[@name = 'login']"));
		driver.findElement(By.xpath("//button[@data-testid= 'royal_login_button']"));
		System.out.println("After Xpath");

		// CSS
		// ID
		System.out.println("Before CSS - ID");
		driver.findElement(By.cssSelector("input[id = 'email']"));

		driver.findElement(By.cssSelector("input#email"));

		driver.findElement(By.cssSelector("#email"));
		System.out.println("After CSS -ID");

		// CLASS


		System.out.println("Before CSS - CLASS");
		driver.findElement(By.cssSelector("a[class = '_sv4']"));

		driver.findElement(By.cssSelector("a._sv4"));

		driver.findElement(By.cssSelector("._sv4"));

		System.out.println("After CSS - CLASS");

		// NAME
		System.out.println("Before CSS - NAME");
		driver.findElement(By.cssSelector("input[name = 'email']"));
		System.out.println("After CSS -NAME");

	}

//	@Test
	public void TC_02_NopCommerce() {
		driver.get("https://demo.nopcommerce.com/");
//

		// Step 1: Click to Login Link
		WebElement linkLogin = driver.findElement(By.xpath("//a[@class = 'ico-login']"));
		linkLogin.click();

		// Step 2: Fill email and password
		WebElement txbEmail = driver.findElement(By.id("Email"));
		txbEmail.clear();
		txbEmail.sendKeys("abc123@gmail.com");

		WebElement txbPassword = driver.findElement(By.id("Password"));
		txbPassword.clear();
		txbPassword.sendKeys("123123");

		// Step 3: Click login button
		WebElement btnLogin = driver.findElement(By.xpath("//button[text() = 'Log in']"));
		btnLogin.click();

		WebElement linkMyAccount = driver.findElement(By.xpath("//div[@class = 'footer']//a[text() = 'My account']"));

		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", linkMyAccount);
		
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", linkMyAccount, "style", "border: 2px solid red; border-style: dashed;");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		linkMyAccount.click();
		
	}
	
//	@Test
	public void TC_03() {
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text() , 'downloads')]"));
		
//		WebElement txbSearchStore =  driver.findElement(By.xpath("//input[contains(@class, 'search-box-text')]"));
//		WebElement txbSearchStore =  driver.findElement(By.xpath("//input[starts-with(@id, 'small')]"));
		WebElement elementRegisterLink = driver.findElement(By.xpath("//a[@class = 'ico-register' and text() = 'Register']"));
	}
	
//	@Test
	public void TC_04() {
		driver.get("https://automation-warrior.blogspot.com/basic-form");
		
		WebElement elementSpan = driver.findElement(By.xpath("//span[text() = concat('Hello \"John\", What' , \"'s happened?\")]"));
		
	}
	
//	@Test
	public void TC_05() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		
//		WebElement elementOne = driver.findElement(By.xpath("//li[6]"));
		WebElement elementOne = driver.findElement(By.xpath("//li[position() = 7]"));
		
		elementOne.click();
		
		sleepInSecond(5);
		
//		List<WebElement> allItemsNotClick = driver.findElements(By.xpath("//li[not (contains(@class, 'ui-selected'))]"));
	}
	
//	@Test
	public void TC_06() {
		driver.get("http://live.techpanda.org/index.php/mobile.html");
		
//		WebElement elementAddCart = driver.findElement(By.xpath("(//button[@title = 'Add to Cart'])[2]"));
		WebElement elementAddCart = driver.findElement(By.xpath("//a[text() = 'Samsung Galaxy']//parent::h2//following-sibling::div[@class = 'actions']//button"));
		
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", elementAddCart, "style", "border: 4px solid red; border-style: dashed;");

		sleepInSecond(5);
	}
	
	@Test
	public void TC_07_Css() {
		driver.get("https://demo.nopcommerce.com/");
		
		// ID
		driver.findElement(By.cssSelector("input[id = 'small-searchterms']"));
		driver.findElement(By.cssSelector("input#small-searchterms"));
		driver.findElement(By.cssSelector("#small-searchterms"));
		
		// Class
		
		// Contains
		driver.findElement(By.cssSelector("input[id *= 'small']"));
	}
	
	public void sleepInSecond(int timeOut) {
		try {
			Thread.sleep(timeOut * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int a = 2; 
		if(a >= 0 && a % 2 == 0) {
			
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}