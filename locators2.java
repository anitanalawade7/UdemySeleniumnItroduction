import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class locators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "/Users/Dell/Documents/geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//*** Parent - Child- Sibling traverse
		String Text = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println("Button Text1 = "+Text);
		
		//*** Child - Parent traverse
		Text = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
		System.out.println("Button Text2 = "+Text);
		
		driver.findElement(By.xpath("//button[text()='Home']")).click();
	}

}
