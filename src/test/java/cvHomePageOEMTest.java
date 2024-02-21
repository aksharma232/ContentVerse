

import org.testng.Assert;
import org.testng.annotations.Test;

public class cvHomePageOEMTest extends baseClass
{
	@Test
	public void cvMainPage() throws InterruptedException
	{
		cvHomePage cv_HP = cv_LP.loginData(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("room"));
		cv_HP.listOfCabinatesPresentInDataBase(prop.getProperty("cabinateName"));
	}
	
}
