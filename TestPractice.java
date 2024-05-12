import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestPractice {
	public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/angularpractice/");
	driver.manage().window().maximize();
	WebElement element = driver.findElement(By.className("class"));
	Actions act = new Actions(driver);
	
	
	act.keyDown(Keys.SHIFT).sendKeys(Keys.END).keyUp(Keys.SHIFT);
	act.keyDown(Keys.CONTROL).sendKeys("A").sendKeys("C");
	}
		
}
