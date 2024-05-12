import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsNavigations {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "/Users/Dell/Documents/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//Run Code in maximize window
		driver.manage().window().maximize();
		
		//Navigation Methods
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice"); Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().forward();
	}

}
