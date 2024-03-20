import java.io.IOException;
import org.testng.annotations.Test;

public class cvNewDocumentTest extends baseClass {

	@Test
	public void newUploadThroughBrowse() throws InterruptedException, IOException
	{
		//cvHomePageOEMTest cv_HPOT = new cvHomePageOEMTest();
		//cv_HPOT.cvMainPage();
		
		cvHomePage cv_HP = cv_LP.loginData(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("room"));
		cv_HP.listOfCabinatesPresentInDataBase(prop.getProperty("cabinateName"));
		cv_HP.selectDrawerPresentInCabinet(prop.getProperty("drawerName"));
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		cv_HP.selectFolderPresentInDrawer(prop.getProperty("folderName"));
		
		cvNewDocumentPage cv_NDP = new cvNewDocumentPage(driver);
				cv_NDP.newDocumentUploadThroughBrowse();
				
				cv_NDP.createdDocument();
	
	}
}
