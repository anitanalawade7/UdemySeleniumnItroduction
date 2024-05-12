import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCart {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
			WebDriver driver =  new ChromeDriver();
			String[] vegetables = {"Cucumber", "Beetroot", "Brocolli"};
			List<String> expectedVegetables = Arrays.asList(vegetables);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
			driver.get("https://rahulshettyacademy.com/seleniumPractise");
			//Thread.sleep(3000);
			
			AddItemsToCart(driver, expectedVegetables);
			driver.findElement(By.cssSelector("img[alt='Cart']")).click();
			driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
			
			//Implicit Wait to load new page (Refer Code at line no 22) //5 seconds wait applied at each and every line 
			//Thread.sleep(5000); 
			driver.findElement(By.className("promoCode")).sendKeys("InvalidPromoCode");
			driver.findElement(By.className("promoBtn")).click();
			System.out.println(driver.findElement(By.className("promoInfo")).getText());
			
			driver.findElement(By.className("promoCode")).clear();
			driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
			driver.findElement(By.className("promoBtn")).click();
			
			//Explicit Wait
			//Thread.sleep(5000);
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
			w.until(ExpectedConditions.textToBe(By.className("promoInfo"),"Code applied ..!"));
			System.out.println(driver.findElement(By.className("promoInfo")).getText());
			
			driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}
	
	public static void AddItemsToCart(WebDriver driver,List<String> expectedVegetables)
	{
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int itemesAdded = 0;
		
		for(int i=0;i<products.size();i++)
		{
			
			String itemName = products.get(i).getText();
			String itemNameTrimmed = itemName.split("-")[0].trim();
			
			if(expectedVegetables.contains(itemNameTrimmed))//(itemName.contains("Cucumber"))
			{
				itemesAdded++;
				System.out.println("*** Clicking on "+itemNameTrimmed);
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(itemesAdded==expectedVegetables.size())
					{break;}
			}
			
		}
	}
	
	
}
