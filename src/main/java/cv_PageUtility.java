import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
		 System.out.println("Downloading Started");
		 
			File folder = new File(UUID.randomUUID().toString());
			folder.mkdir();
			
				FluentWait<File> wait = new FluentWait<File>(folder)
					.withTimeout(Duration.ofMinutes(5))
					.pollingEvery(Duration.ofSeconds(10))
					.ignoring(Exception.class)
					.withMessage("File is not downloaded");
			wait.until(file -> file.exists() && file.canRead());
		
			File allFiles[] = folder.listFiles();
			if (allFiles.length!=0)
			{
				System.out.println(allFiles);
				boolean fileDownloaded = wait.until(file -> file.exists() && file.canRead());
				
				if (fileDownloaded)
				{
					System.out.println("File is downloaded completely");
				}
				else {
					System.out.println("Download is in progress...");
					}
			}
		}
}
