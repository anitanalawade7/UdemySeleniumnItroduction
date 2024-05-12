import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("okayBtn"))));
		driver.findElement(By.id("okayBtn")).click();;
		
		WebElement dropdown = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		Select dropdownitems = new Select(dropdown);
		dropdownitems.selectByVisibleText("Consultant");
		
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[class*='btn-primary']"))));
		List<WebElement> products = driver.findElements(By.xpath("//app-card-list/app-card"));
		for(int i=0;i<products.size();i++)
		{
			driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();
		}
		
		driver.findElement(By.cssSelector("a[class*='btn-primary']")).click();
	}

}
