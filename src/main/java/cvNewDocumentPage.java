import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class cvNewDocumentPage extends cv_PageUtility {
	
	WebDriver driver;
	Actions act;
	
	public cvNewDocumentPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="createDocument")
	WebElement createDocument;
	
	@FindBy(xpath="//span[@id='commentMessage']")
	WebElement newDocumentMsg;
	
	@FindBy(xpath="//button[@id='CommentsMessageModelOk']")
	WebElement btnOK;
	
	@FindBy(xpath="//div[@id='addPagesDropDown']//span[1]")
	WebElement addButton;
	
	@FindBy(xpath="//input[@id='viewDocumentAddPages']")
	WebElement browseFile;
	
	@FindBy(xpath="//select[@id='docTypeList']")
	WebElement docType;
	
	@FindBy(xpath="//input[@id='indicesViewText_1']")
	WebElement AuthorsList;
	
	@FindBy(id="retainBtn")
	WebElement retainCheckbox;
	
	@FindBy(xpath="//button[@id='createDocumentSubmit']")
	WebElement btnCreateDoc;
	
	@FindBy(xpath="//div[@id='messageModel']")
	WebElement messageBox;
	
	@FindBy(xpath="//span[@id='createDocumentMessage']")
	WebElement docCreatedMsg;
	
	@FindBy(xpath="//button[@id='modelHome']")
	WebElement btnNavigateDoc;
	
	@FindBy(xpath="//button[@id='viewCreatedDocument']")
	WebElement btnViewDoc;
	
	@FindBy(xpath="//button[@id='modelNewDocument']")
	WebElement btnNewDoc;
	
	public void newDocumentUploadThroughBrowse() throws InterruptedException, IOException
	{
		act = new Actions(driver);
		Thread.sleep(1000);
		createDocument.click();
		
		isDisaplyed(newDocumentMsg);
		if(newDocumentMsg.getText().trim().equalsIgnoreCase("Permission Denied"))
		{
			System.out.println(newDocumentMsg.getText());
			btnOK.click();
		}
		else
		{
			browseFile.sendKeys("C:\\Users\\Satyendra\\Downloads\\pdf-test.pdf");
			Thread.sleep(5000);
			Select type = new Select(docType);
			type.selectByVisibleText("Test");
			isDisaplyed(AuthorsList);
			AuthorsList.sendKeys("Test1");
		
			//retainCheckbox.click();
			btnCreateDoc.click();
			isDisaplyed(messageBox);
			System.out.println(docCreatedMsg.getText());
		}
	}
	
	public void documentNavigate()
	{
		btnNavigateDoc.click();
	}
	public void documentView()
	{
		btnViewDoc.click();
	}
	public void documentNew()
	{
		btnNewDoc.click();
	}
	
	public void createdDocument()
	{
		if(docCreatedMsg.getText().trim().equalsIgnoreCase("Document created successfully"))
		{
			documentNavigate();
		}
	}
}