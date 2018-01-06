package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Browser;

public class ShoppingCart {
	
	@FindBy (css = "span[class='cssButton normal_button button  button_checkout']")
	WebElement checkout;
	
	public ShoppingCart(WebDriver driver){
		Browser.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void checkoutPress(){
		checkout.click();
	}
}
