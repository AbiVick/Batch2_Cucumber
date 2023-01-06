package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		
		
		
		this.driver = driver;
		
		
	}
	
	
	public void WaitForElement(WebElement ele, long num1) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, num1);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}
	

}
