import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cv_PageUtility 
{
	WebDriver driver;
		
	public cv_PageUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean isDisaplyedE(WebElement Ele, long tm) 
	{
		boolean isDisplayed = false;
		try 
		{
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(15));
			wt.until(ExpectedConditions.elementToBeClickable(Ele));
			isDisplayed = true;
		} 
		catch (Exception e)

		{
			e.printStackTrace();
		}
		return isDisplayed;

	}

	
	
	
	
	
	
}
