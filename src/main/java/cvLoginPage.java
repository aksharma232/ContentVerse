import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cvLoginPage extends cv_PageUtility
{
	WebDriver driver;
	
	public cvLoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="userName")
	WebElement cv_UserName;
	
	@FindBy(id="loginPassword")
	WebElement cv_Password;
	
	@FindBy(id="rooms")
	WebElement rooms_List;
	
	@FindBy(id="//div[@id='loginModel']")
	WebElement loginActivePopup;
	
	@FindBy(id="cvModelLoginValidationOk")
	WebElement loginActivePopupYesButton;
	
	public void roomListValue(String roomName)
	{
		Select rooms_Lists = new Select(rooms_List);
		rooms_Lists.selectByValue(roomName);
	}
	
	@FindBy(id="submitid")
	WebElement loginButton;
	
	@FindBy(id="logedinusername")
	WebElement logedinUserNameAfterLogin;
	
	public cvHomePage loginData(String username,String password, String room)
	{
		cv_UserName.sendKeys(username);
		cv_Password.sendKeys(password);
		roomListValue(room);
		loginButton.click();
		if(isDisaplyed(loginActivePopupYesButton))
		{
			loginActivePopupYesButton.click();
		}
		cvHomePage cv_HP = new cvHomePage(driver);
		return cv_HP;
	}
}
