import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass 
{
	String configFilePath;
	FileInputStream fis;
	Properties prop;
	public WebDriver driver;
	cvLoginPage cv_LP;
	
	@BeforeClass
	public void initalsetup() throws IOException
	{
		configFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		fis = new FileInputStream(configFilePath);
		prop = new Properties();
		prop.load(fis);
	}
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println(prop.getProperty("browser"));
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome"))
		{

			HashMap<String, Object> prefs = new HashMap<String, Object>();
		 	prefs.put("profile.default_content_settings.popups", false);
		 	
		 	//prefs.put("profile.prompt_for_download:False", content_settings);
		 	//options.setEnableDownloads(true);
		 	
		 	File folder = new File(UUID.randomUUID().toString());
			folder.mkdir();
			
		 	prefs.put("download.default_directory", folder.getAbsolutePath());
		 	prefs.put("download.prompt_for_download", false);
		 	prefs.put("safebrowsing.enabled", false);
		 	
		 	ChromeOptions options = new ChromeOptions();
		 	prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
		 	options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("prefs", prefs);	
			
			options.addArguments("disable-popup-blocking");
				
			DesiredCapabilities dcap = new DesiredCapabilities();
			dcap.setCapability(ChromeOptions.CAPABILITY, options);
			dcap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			
			options.addArguments("--remote-allow-origins=*");
			//options.addArguments("--headless");
			driver = WebDriverManager.chromedriver().clearDriverCache().capabilities(options).create();
			//driver = new ChromeDriver(options);
			}
		else if(prop.getProperty("browser").equalsIgnoreCase("Firefox"))
			{
			
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions fop = new FirefoxOptions();
				driver = new FirefoxDriver(fop);
			}
		
		driver.get(prop.getProperty("url"));
		
		cv_LP = new cvLoginPage(driver);
	}
	
/*	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	*/
	
}
