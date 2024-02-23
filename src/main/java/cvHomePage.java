import java.awt.Desktop.Action;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="//div[@id='viewDocumentnavigator']//ul//ul//ul//li//a")
	List<WebElement> selectFolder;
	
	@FindBy(id="documentListDiv")
	WebElement documentListBox;
	
	@FindBy(xpath="//table[@id='documentListTable']//tbody")
	List<WebElement> documentListInFolder;
	
	@FindBy(id="selectall")
	WebElement seleteAllCheckbox;
	
	@FindBy(id="documentSendToLi")
	WebElement sendTo;
	
	@FindBy(id="sendToExport")
	WebElement sendToExport;
	
	@FindBy(id="zipPasswordInput")
	WebElement passwordOfExportedZip;
	
	@FindBy(id="saveSendToDocument")
	WebElement okButtonToExport;
	
	@FindBy(id="messageBoxFD")
	WebElement exportInfoMessageBox;
	
	@FindBy(id="detailsBlock")
	WebElement exportInfoBox;
	
	@FindBy(id="messageButtonOKFD")
	WebElement okButtonInMessage;
	
	
	
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
				act.moveToElement(selectFolder.get(k)).click().build().perform();
			}
		}
	}
	
	public void documentListTable() throws InterruptedException
	{
		for (int i=0; i<documentListInFolder.size(); i++)
		{
			//cv_PageUtility cv_PU = new cv_PageUtility(driver);
			//cv_PU.isVisible();
			Thread.sleep(3000);
			if(documentListInFolder.get(i).getText().trim().equalsIgnoreCase("No data available in table"))
			{
				System.out.println(documentListInFolder.get(i).getText());
				System.out.println("TestCase Failed");
			}
			else
			{
				System.out.println("---->>"+documentListInFolder.get(i).getText());
				seleteAllCheckbox.click();
				Thread.sleep(5000);
				act.moveToElement(documentListBox).contextClick(documentListBox).perform();
				act.moveToElement(sendTo).click().perform();
				act.moveToElement(sendToExport).click().perform();
				
				Thread.sleep(3000);
				okButtonToExport.click();
				System.out.println("---> Step1");
				Thread.sleep(5000);
				if (exportInfoBox.getText().trim().equalsIgnoreCase("Error On Download"))
				{
					System.out.println(exportInfoBox.getText());
					okButtonInMessage.click();
				}
				else
				{
					//cv_PageUtility cv_PU = PageFactory.initElements(driver, cv_PageUtility.class);
					WebDriverWait wt = new WebDriverWait(driver, Duration.ofMinutes(2));
					wt.until(ExpectedConditions.visibilityOf(exportInfoMessageBox));
					Thread.sleep(5000);
					fileDownloadInBrowser();
				}
			}
		}
	}
}
