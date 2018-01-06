package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Browser;

public class CheckoutSuccessPage {
	

	@FindBy (id = "checkoutSuccessHeading")
	WebElement checkoutSuccessText;
	
	
	public CheckoutSuccessPage(WebDriver driver){
		Browser.driver= driver;
		PageFactory.initElements(driver, this);	
	}

	public String getCheckoutSuccessHeading() {
		String result =  checkoutSuccessText.getText();
		return result;
	}
}
