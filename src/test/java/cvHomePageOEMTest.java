import java.io.IOException;
import org.testng.annotations.Test;

public class cvHomePageOEMTest extends baseClass
{
	@Test
	public void cvMainPage() throws InterruptedException, IOException
	{
		cvHomePage cv_HP = cv_LP.loginData(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("room"));
		cv_HP.listOfCabinatesPresentInDataBase(prop.getProperty("cabinateName"));
		
		//cv_HP.listOfDrawersPresentInCabinet();
		
		cv_HP.selectDrawerPresentInCabinet(prop.getProperty("drawerName"));
		
		//cv_HP.listOfFoldersPresentInDrawer();
		
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		cv_HP.selectFolderPresentInDrawer(prop.getProperty("folderName"));
		
		cv_HP.documentListTable();
		
		//cv_HP.exportDocuments();
	}
}

