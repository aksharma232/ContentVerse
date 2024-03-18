import org.openqa.selenium.WebDriver;

public class cvNewDocumentTest {

	public void newUploadThroughBrowse()
	{
		cvNewDocumentPage cv_NDP = new cvNewDocumentPage(driver);
		cv_NDP.newDocumentUploadThroughBrowse();
	}
}
