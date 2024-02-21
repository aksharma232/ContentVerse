

import org.testng.Assert;
import org.testng.annotations.Test;

public class cvHomePageOEMTest extends baseClass
{
	@Test
	public void cvMainPage() throws InterruptedException
	{
		cvHomePage cv_HP = cv_LP.loginData(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("room"));
		//cv_HP.listOfCabinatesPresentInDataBase();
		cv_HP.listOfCabinatesPresentInDataBase(prop.getProperty("cabinateName"));
		
		cv_HP.listOfDrawersPresentInCabinet();
		cv_HP.selectDrawerPresentInCabinet(prop.getProperty("drawerName"));
		
		cv_HP.listOfFoldersPresentInDrawer();
		cv_HP.selectFolderPresentInDrawer(prop.getProperty("folderName"));
	}
	
}
