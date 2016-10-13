import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Guru99Bank {

	// public static void main(String[] args) {

	// Initialization of variables
	WebDriver driver = null;
	String propertyKey = null;
	String geckoDriverPath = null;
	String bankURL = "http://www.demo.guru99.com/V4/";
	String userId = "mngr51699";
	String password = "mAhUqAj";
	String expectedTitle = "Guru99 Bank Manager HomePage";
	String homePageTitle = "Guru99 Bank Home Page";
	String expectedHeadline = "Guru99 Bank";

	// ------------- Page Objects ----------------//
	// ------- xPath ---------------//
	String uid = "//input[@name='uid']";
	String pid = "//input[@name='password']";
	String logButton = "//input[@name='btnLogin']";
	String mgrId = "//tr[@class='heading3']/td";

	// -------- CSS Selector -----------//
	String check1 = ".barone";

	// Browser selection
	// 1 - Firefox
	// 2 - Chrome
	int Browser = 2;

	@BeforeClass
	public void setup() {
		if (Browser == 1) {
			propertyKey = "webdriver.gecko.driver";
			geckoDriverPath = "C:\\Vijay\\Automation\\GeckoDrivers\\Firefox\\geckodriver.exe";
			System.setProperty(propertyKey, geckoDriverPath);
			driver = new FirefoxDriver();
		} else if (Browser == 2) {
			propertyKey = "webdriver.chrome.driver";
			geckoDriverPath =  "C:\\Vijay\\Automation\\GeckoDrivers\\chrome\\chromedriver.exe";
			System.setProperty(propertyKey, geckoDriverPath);
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}

	@Test
	public void pageLoad(){
		driver.get(bankURL);
		Assert.assertEquals(driver.getTitle(), homePageTitle);
	}
	
	@Test(dependsOnMethods="pageLoad")
	public void Login() {
		driver.findElement(By.xpath(uid)).sendKeys(userId);
		driver.findElement(By.xpath(pid)).sendKeys(password);
		driver.findElement(By.xpath(logButton)).click();

		// Explicit Wait conditions
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// WebElement mgrIdText =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mgrId)));
		// String mgrLkt = mgrIdText.getText();

		String mgrLkt = driver.findElement(By.xpath(mgrId)).getText();
		String ManagerId = mgrLkt.substring(12, mgrLkt.length());

		// Assertions on the page
		Assert.assertEquals(driver.findElement(By.cssSelector(check1))
				.getText(), expectedHeadline);
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		Assert.assertEquals(ManagerId, userId);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	// }

}
