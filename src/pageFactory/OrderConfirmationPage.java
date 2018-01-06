package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Browser;

public class OrderConfirmationPage {
	

	
	@FindBy (css = "input[value='Confirm Order']")
	WebElement confirmOrderButton;
	
	
	public OrderConfirmationPage(WebDriver driver){
		Browser.driver= driver;
		PageFactory.initElements(driver, this);	
	}

	public void confirmOrderPress(){
		confirmOrderButton.click();
	}
	
}
