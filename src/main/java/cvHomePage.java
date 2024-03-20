
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cvHomePage extends cv_PageUtility{
//init web driver
	WebDriver driver;
	Actions act;
	
	public cvHomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		// Find WebElement Of Home Page
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
	
	@FindBy(xpath="//a[@id='documentListSubMenu']")
	WebElement documentListMenu;

	@FindBy(xpath="//a[@id='documentSendTo']")
	WebElement sendTo;
	
	@FindBy(id="sendToExport")
	WebElement sendToExport;
	
	@FindBy(id="zipPasswordInput")
	WebElement passwordOfExportedZip;
	
	@FindBy(id="saveSendToDocument")
	WebElement okButtonToExport;
	
	@FindBy(id="messageBoxFD")
	WebElement exportInfoMessageBox;
	
	@FindBy(xpath="//span[@id='messageContentFD']")
	WebElement exportMessageBox;
	
	
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
				act.moveToElement(selectFolder.get(k)).click(selectFolder.get(k)).build().perform();		
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
				System.out.println("Documents in selected folder ---->>" +documentListInFolder.get(i).getText());
			}
		  }
	  }
			public void exportDocuments() throws InterruptedException
			{
				seleteAllCheckbox.click();
				Thread.sleep(3000);
				act.moveToElement(documentListBox).contextClick(documentListBox).perform();
				
				//act.moveToElement(documentListMenu);
				Thread.sleep(3000);
				act.moveToElement(sendTo).click().build().perform();
				
				act.moveToElement(sendToExport).click().build().perform();
				okButtonToExport.click();
			
				//WebDriverWait wait = new WebDriverWait(driver,0);
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofMinutes(30))
						.pollingEvery(Duration.ofSeconds(10))
						.ignoring(Exception.class);
				wait.until(ExpectedConditions.visibilityOf(exportInfoBox));
				
				if (exportInfoBox.getText().trim().equalsIgnoreCase("Error On Download"))
				{
					System.out.println(exportInfoBox.getText());
					okButtonInMessage.click();
				}
				else
				{
					//cv_PageUtility cv_PU = PageFactory.initElements(driver, cv_PageUtility.class);
					//Thread.sleep(5000);
					fileDownloadInBrowser();
				}
			}
			cvNewDocumentPage cv_NDP = new cvNewDocumentPage(driver);
}