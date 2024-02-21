import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cvHomePage extends cv_PageUtility{

	WebDriver driver;
	
	public cvHomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="navigationMenuBtn")
	WebElement dataBaseNameInMenu;
	
	@FindBy(id="advSearchMenuBtn")
	WebElement searchButtonInMenu;

	@FindBy(xpath="//div[@id='viewDocumentnavigator']//ul//li")
	List<WebElement> listOfCabinates; 
	
	public void listOfCabinatesPresentInDataBase(String cabinateName) throws InterruptedException
	{
		//boolean status = false;
		Thread.sleep(4000);
		//ArrayList<String> listofCabinatesNames = new ArrayList<String>();
		
		for(int i=0;i<listOfCabinates.size();i++)
		{
			if(listOfCabinates.get(i).getText().trim().equalsIgnoreCase(cabinateName))
			{
				System.out.println("I am in if condition");
				listOfCabinates.get(i).click();
				Actions act = new Actions(driver);
				act.doubleClick(listOfCabinates.get(i)).build().perform();
				Thread.sleep(5000);
				
			}
		}
		
	}
}
