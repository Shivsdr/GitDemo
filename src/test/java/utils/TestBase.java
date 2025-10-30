package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {
		
		
		System.out.println("Some random stuff for merge");
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties"));
		
		String url = properties.getProperty("url");
		String browser_properties = properties.getProperty("browser");
		String browser_mvn = System.getProperty("browser");
		
		String browser = (browser_mvn!=null) ?  browser_mvn : browser_properties;
		
		if(driver==null) {
			if(browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				driver = new ChromeDriver();
			}
			
			driver.get(url);
			
		}
		
		System.out.println("Change 3");
		System.out.println("Change 4");
		System.out.println("Change 5");
		System.out.println("Change 6");
		return driver;
	}
}
