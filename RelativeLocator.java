import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class RelativeLocator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
		//***********************Relative Locators:  above(), Below(), toLeftOf(), toRightOf()******************8
		WebElement nameTextBox = driver.findElement(By.cssSelector("input[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText());
		
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

		WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		
		//************************Handling Multiple Windows***************************************
		
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> win = driver.getWindowHandles();
		Iterator it = win.iterator();
		String parentWindow = (String) it.next();
		String childWindow = (String) it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindow);
		nameTextBox.sendKeys(courseName);
		
		//************************Capture WebElement Screenshot*****************************************
		
		File f = nameTextBox.getScreenshotAs(OutputType.FILE);
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("screenshot.png"));
		FileUtils.copyFile(f1, new File("fullscreenScrrenshot.png"));
		
		//************************Capture WebElement Height and Width***********************************
		int h = nameTextBox.getRect().getHeight();
		int w = nameTextBox.getRect().getWidth();
		System.out.println("Height: "+h+"and Width: "+w);
	}

}
