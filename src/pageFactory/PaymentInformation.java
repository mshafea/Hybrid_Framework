package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Browser;

public class PaymentInformation {
	
	@FindBy (id = "disc-ot_coupon")
	WebElement redemptionCode;
	
	@FindBy (css = "input[value='Continue']")
	WebElement continueButton;
	
	@FindBy (name = "comments")
	WebElement orderComments;
	
	public PaymentInformation(WebDriver driver){
		Browser.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void redCodeFilling(){
		redemptionCode.sendKeys("1234");
	}
	
	public void continuePress(){
		continueButton.click();
	}
	
	public void orderCommentsFilling () {
		orderComments.sendKeys("This is for test");
	}
	
}
