package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Browser;


public class HomePage {
  

	@FindBy (linkText="Log In")
	WebElement zencartLogin;
	
	@FindBy (linkText="Software")
	WebElement softwareLink;
	
	public HomePage(WebDriver driver){
		Browser.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	//Go to Login Page
	public void selectLoginPage(){
		zencartLogin.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectSoftware(){
		softwareLink.click();
	}
	
}
