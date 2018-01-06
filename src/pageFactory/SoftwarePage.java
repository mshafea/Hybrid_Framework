package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Browser;

public class SoftwarePage {
	
	@FindBy (linkText="Unreal Tournament Linked")
	WebElement unrealTournament;
	
	@FindBy (css = "input[value='Add to Cart']")
	WebElement addToCart;
	
	public SoftwarePage(WebDriver driver){
		Browser.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void unrealTournamentSelection(){
		unrealTournament.click();
	}
	
	public void addToCartPress(){
		addToCart.click();
	}

}
