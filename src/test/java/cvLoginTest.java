import org.testng.Assert;
import org.testng.annotations.Test;

public class cvLoginTest extends baseClass 
{

	@Test
	public void loginTestWithValidData()
	{
		cv_LP.loginData(prop.getProperty("username"),prop.getProperty("password"),prop.getProperty("room"));
		Assert.assertTrue(cv_LP.logedinUserNameAfterLogin.isDisplayed());
	}
	
}
