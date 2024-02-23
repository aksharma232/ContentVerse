import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class cv_PageUtility 
{
	WebDriver driver;
		
	public cv_PageUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	
	 public boolean isDisaplyed(WebElement Ele) 
	{
		boolean isDisplayed = false;
		try 
		{
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
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
	 public void fileDownloadInBrowser()
		{
			File folder = new File(UUID.randomUUID().toString());
			folder.mkdir();
			
			ChromeOptions options = new ChromeOptions();
			
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("profile.default_directory", folder.getAbsolutePath());
			options.setExperimentalOption("prefs", prefs);
			
			DesiredCapabilities dcap = new DesiredCapabilities();
			dcap.setCapability(ChromeOptions.CAPABILITY, options);
			
			File allFiles[] = folder.listFiles();
			if (allFiles.length!=0)
			{
				System.out.println(allFiles);
			}
			
		}
}
