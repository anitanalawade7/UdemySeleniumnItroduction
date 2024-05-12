import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Anita Nalawade");
		driver.findElement(By.name("email")).sendKeys("anita@Gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abcdefgh");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.name("inlineRadioOptions")).click();
		//driver.findElement(By.cssSelector("#exampleFormControlSelect1 option:nth-child(2)")).click();
		WebElement dropdown=driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
		Select dropdownitems = new Select(dropdown);
		dropdownitems.selectByVisibleText("Female");
		
		driver.findElement(By.name("bday")).sendKeys("01/02/2000");
		driver.findElement(By.cssSelector("input[class*='btn-success']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	}

}
