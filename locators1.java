import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "/Users/Dell/Documents/geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		locators1 obj = new locators1();
		String Password = obj.getPassword(driver);
		
		String Name="Anita";
		driver.findElement(By.id("inputUsername")).sendKeys(Name);
		driver.findElement(By.name("inputPassword")).sendKeys(Password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		
		//*** TagName
		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		Assert.assertEquals(text,"You are successfully logged in.");
		
		//*** Parent Child traverse
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		//OR
		String header = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		Assert.assertEquals(header, "Hello "+Name+",");
		
		//*** Xpath using button text
		//<button class="logout-btn">Log Out</button>
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
	
	public String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.linkText("Forgot your password?")).click();Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String PasswordText = driver.findElement(By.cssSelector("p[class='infoMsg'")).getText();
		
		// Please use temporary password 'rahulshettyacademy' to Login.
		String Password= PasswordText.split("'")[1].split("'")[0];
		System.out.println("Password is "+Password);
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();Thread.sleep(2000);
		return Password;
	}

}
