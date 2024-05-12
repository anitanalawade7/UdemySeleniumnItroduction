import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Scroll
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		// Grid Control
		System.out.println("Row Count: "+driver.findElements(By.cssSelector(".table-display tr")).size());
		System.out.println("Column Count: "+driver.findElements(By.cssSelector(".table-display tr th")).size());
		List<WebElement> rowItems = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
		for(int i=0;i<rowItems.size();i++)
		{
			System.out.println(rowItems.get(i).getText());
		}
	}

}
