import java.io.Console;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EpamInterviewQuestion {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.iplt20.com/points-table/men/2023");
		Thread.sleep(5000);
		List<WebElement> rows = driver.findElements(By.cssSelector("#pointsdata tr"));
		Map<String, String> dict = new HashMap<>();
		
		for(int i=0;i<rows.size();i++)
		{
			WebElement row = rows.get(i);
			dict.put(row.findElement(By.cssSelector("h2")).getText(), 
					row.findElement(By.cssSelector("td:nth-child(6)")).getText());
		}

		for (Map.Entry<String, String> entry : ((Map<String, String>) rows).entrySet()) {
            String team = entry.getKey();
            String wins = entry.getValue();
            System.out.println(team + " Team Won" + wins + " matches");
        }

	}
}
