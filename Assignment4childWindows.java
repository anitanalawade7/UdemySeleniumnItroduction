import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4childWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> win = driver.getWindowHandles();
		Iterator it = win.iterator();
		String parentWindow = it.next().toString();
		String childWindow = it.next().toString();
		
		driver.switchTo().window(childWindow);
		String childWindowText = driver.findElement(By.cssSelector("[class='example'] h3")).getText();
		System.out.println(childWindowText);
		
		driver.navigate().back();
		driver.switchTo().window(parentWindow);
		String parentWindowText = driver.findElement(By.cssSelector("[class='example'] h3")).getText();
		System.out.println(parentWindowText);
	}

}
