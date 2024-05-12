import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		SoftAssert softassert = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> urllist = driver.findElements(By.cssSelector("#gf-BIG a")); //Get List of All URL links on webpage to test
		
		for(int i=0;i<urllist.size();i++)
		{
		String urlName = urllist.get(i).getAttribute("href"); //Step 1: Get URL : Don't use link text as it is not reliable
		HttpURLConnection conn = (HttpURLConnection)new URL(urlName).openConnection();//Step 2: Create connection and open connection
		
		conn.setRequestMethod("HEAD");//Step 3: Set Request Method HEAD
		int respoceCode = conn.getResponseCode();//Step 4: get responceCode or respoceBody
		String responseBody = conn.getResponseMessage();
		
		System.out.println("Responce Code: "+respoceCode); //if working=> 200 broken=>404
		System.out.println("Responce Body: "+responseBody); //if working=> OK broken=>Not Found
		
		softassert.assertTrue(respoceCode<400, "URL is not working for "+urlName);
		}
		softassert.assertAll();
	}
}
