import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MiscTopicsInSelenium {
				
	public static void main(String[] args) throws IOException
	{
			//*** Handling HTTP certifications
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			
			//** Add Proxy
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("ipaddress:4444");
			options.setCapability("proxy", proxy);
			
			//*** Set Experimental options
			Map<String, Object> prefs = new HashMap<String, Object>();
			options.setExperimentalOption("prefs", prefs);
			prefs.put("download.default_directory", "/directory/path");
			
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://expired.badssl.com/");
			
			//*** Take Screenshot
			File srcpath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destpath = new File("D://Selenium screenshots/screenshot.png");
			FileUtils.copyFile(srcpath, destpath);
			
			
	}
}
