import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts {

	public static void main(String[] args) {
		WebDriver driver;
		String setURL = "http://output.jsbin.com/usidix/1";
		String geckoDriverPath = "C:\\Vijay\\Automation\\GeckoDrivers\\Firefox\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);

		driver = new FirefoxDriver();
		driver.get(setURL);
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
		
		String content = driver.findElement(By.xpath("//html/body/p")).getText();
		System.out.println(content);
		
		driver.quit();
		System.exit(0);
		
		
	}

}
