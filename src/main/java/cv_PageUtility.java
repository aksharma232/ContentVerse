import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cv_PageUtility 
{
	WebDriver driver;
		
	public cv_PageUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean isDisaplyedE(WebElement Ele) 
	{
		boolean isDisplayed = false;
		try 
		{
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
			wt.until(ExpectedConditions.elementToBeClickable(Ele));
			if(Ele.isDisplayed())
			{	
			isDisplayed = true;
			}
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return isDisplayed;
	}
}
