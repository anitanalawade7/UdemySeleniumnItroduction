import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6EndToEndPgming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
		String LabelText = driver.findElement(By.xpath("//input[@type='checkbox'][1]/parent::label")).getText();
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(LabelText);
		
		driver.findElement(By.name("enter-name")).sendKeys(LabelText);
		driver.findElement(By.id("alertbtn")).click();
		
		String AlertText = driver.switchTo().alert().getText();
		Assert.assertTrue(AlertText.contains(LabelText));
		driver.switchTo().alert().accept();
		
	}

}
