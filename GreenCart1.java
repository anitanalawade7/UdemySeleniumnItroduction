import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class GreenCart1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.linkText("Top Deals")).click();
		Thread.sleep(5000);
		
		Set<String> win = driver.getWindowHandles();
		Iterator it = win.iterator();
		String parentWindow = (String) it.next();
		String childWindow = (String) it.next();
		driver.switchTo().window(childWindow);
		
		String value = driver.findElement(By.xpath("//tr/th[1]")).getAttribute("aria-sort");
		if(value.equals("descending"))
			driver.findElement(By.xpath("//tr/th[1]")).click();
		 
		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));//5 rows
		List<String> originalValues = items.stream().map(s->s.getText()).collect(Collectors.toList());//getText and convert into list
		
		originalValues.stream().forEach(s->System.out.println(s));
		List<String> sortedValues = originalValues.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalValues.equals(sortedValues));
	}

}
