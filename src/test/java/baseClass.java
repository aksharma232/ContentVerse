import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
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
			ChromeOptions options = new ChromeOptions();
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
