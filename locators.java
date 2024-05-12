import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "/Users/Dell/Documents/geckodriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//open url
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		
		//locators by id, name, classname
		driver.findElement(By.id("inputUsername")).sendKeys("anita");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//*** css selector tagname.classname tagname#id
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//*** linktext for href attributes
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//*** xpath //tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Anita");
		
		//*** css tagname[attribute='value']
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("anitanalawade@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		
		//*** index 
		driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("Anita1");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("anitanalawade1@gmail.com");
		
		//*** Parent-Child traverse
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210");    driver.findElement(By.xpath("//form/input[3]")).clear();
		driver.findElement(By.cssSelector("form input:nth-child(4)")).sendKeys("1234567890");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.className("infoMsg")).getText());
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//*** Regular Expressions (Use partial keywords)
		//<input type="text" placeholder="Username" id="inputUsername" value="">
		driver.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys("Anita");
		//<input type="password" placeholder="Password" name="inputPassword" value="">
		driver.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		
		//*** xpath using btntext
		//<button class="submit signInBtn" type="submit">Sign In</button>
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
