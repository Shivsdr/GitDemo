package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchWindowToChild() {
		String parentWindow = driver.getWindowHandle();
	    Set<String> windows = driver.getWindowHandles();
	    for(String currWindow : windows) {
	    	if(!currWindow.equals(parentWindow)) {
	    		driver.switchTo().window(currWindow);
	    		break;
	    	}
	    }
	}
	
	// this is random code for merge 
}
