import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class MyFirstAutomationScript {
	public static void main(String[] args) {
		
		String geckoDriverPath = "C://Vijay//Automation//GeckoDrivers//geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http://accounts.google.com";
				
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
		
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys(new String[]{"sekhar5955"});
		//email.sendKeys("sekhar5955");
		
		WebElement next = driver.findElement(By.id("next"));
		next.click();
		
		//String profileName = driver.findElement(By.xpath("//*[@id='profile-name']")).getText();
		//String profileName = driver.findElement(By.xpath("//*[@id='gaia_loginform']/div[2]/div/div[1]/p")).getAttribute("innerText");
		//String profileName = driver.findElement(By.cssSelector("p#profile-name")).getText();
		String profileName = driver.findElement(By.xpath("//*[@id='email-display']")).getText();
		System.out.println("This is the profile Name : " + profileName);	
		Assert.assertEquals("sekhar5955@gmail.com", driver.findElement(By.xpath("//*[@id='email-display']")).getText());

		
		driver.close();
		driver.quit();
		
		System.exit(0);
	}

}