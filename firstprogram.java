import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstprogram {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "/Users/Dell/Documents/chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "/Users/Dell/Documents/geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		//System.setProperty("webdriver.edge.driver", "/Users/Dell/Documents/msedgedriver.exe");
		//WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
