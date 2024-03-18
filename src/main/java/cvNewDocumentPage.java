import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	
	@FindBy(xpath="//div[@id='addPagesDropDown']//span[1]")
	WebElement addButton;
	
	@FindBy(xpath="//div[@id='addDocdropdwn']//div[@id='fileUpload']")
	WebElement fileUpload;
	
	@FindBy(xpath="//input[@id='indices_5']")
	WebElement ReportName;
	
	@FindBy(id="retainBtn")
	WebElement retainCheckbox;
	
	@FindBy(id="modelNewDocument")
	WebElement newButton;
	
	public void newDocumentUploadThroughBrowse() throws InterruptedException, IOException
	{
		createDocument.click();
		act = new Actions(driver);
		act.moveToElement(addButton).click();
		Thread.sleep(3000);
		fileUpload.click();
		
		Runtime.getRuntime().exec("D:\\Satyen\\MyAccount\\Selenium Practice\\AutoIT\\Content Verse\\UploadNewDocument.exe");
		Thread.sleep(5000);
		Select docType = new Select(driver.findElement(By.xpath("//select[@id='docTypeList']")));
		Thread.sleep(3000);
		docType.selectByValue("1");
		Thread.sleep(3000);
		
		//cv_HP.retainCheckbox.click();
		driver.findElement(By.xpath("//button[@id='createDocumentSubmit']")).click();
		newButton.click();
	}
}