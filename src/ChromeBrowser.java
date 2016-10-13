import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {
	public static void main(String[] args) {
		String geckoDriverPath = "C:\\Vijay\\Automation\\GeckoDrivers\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", geckoDriverPath);
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.mortgagecalculator.org/");
		System.out.println(driver.getTitle());
		driver.close();
	}
}