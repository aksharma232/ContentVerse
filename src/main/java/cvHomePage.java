import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class cvHomePage extends cv_PageUtility{

	WebDriver driver;
	Actions act;
	
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
	
	@FindBy(xpath="//div[@id='viewDocumentnavigator']//ul//ul//li")
	List<WebElement> listOfDrawers;
	
	@FindBy(xpath="//div[@id='viewDocumentnavigator']//ul//ul//ul//li")
	List<WebElement> listOfFolders;
	
	public void listOfCabinatesPresentInDataBase(String cabinateName) throws InterruptedException
	{
		
		Thread.sleep(5000);
		for(int i=0;i<listOfCabinates.size();i++)
		{
			//System.out.println(listOfCabinates.get(i).getText());
			
			if(listOfCabinates.get(i).getText().trim().equalsIgnoreCase(cabinateName))
			{
				String cabinet_name = listOfCabinates.get(i).getText();
				System.out.println(cabinet_name);
				act = new Actions(driver);
				act.doubleClick(listOfCabinates.get(i)).build().perform();
				Thread.sleep(5000);
			}
		 }
	}
	
	public void listOfDrawersPresentInCabinet() throws InterruptedException
	{
		for (int j=0; j<listOfDrawers.size(); j++)
		{
			System.out.println(listOfDrawers.get(j).getText());
		}
	}
	
	public void selectDrawerPresentInCabinet(String drawerName) throws InterruptedException
	{
		for (int j=0; j<listOfDrawers.size(); j++)
		{
			if(listOfDrawers.get(j).getText().trim().equalsIgnoreCase(drawerName))
			{
				act = new Actions(driver);
				act.doubleClick(listOfDrawers.get(j)).build().perform();
			}
		}
	}
	public void listOfFoldersPresentInDrawer() throws InterruptedException
	{
		for (int k=0; k<listOfFolders.size(); k++)
		{
			System.out.println("---->>"+listOfFolders.get(k).getText());
		}
	}
	
	public void selectFolderPresentInDrawer(String folderName) throws InterruptedException
	{
		for (int k=0; k<listOfFolders.size(); k++)
		{
			if(listOfFolders.get(k).getText().trim().equalsIgnoreCase(folderName))
			{
				act = new Actions(driver);
				act.moveToElement(listOfFolders.get(k)).click().build().perform();
			}
		}
	}
}
