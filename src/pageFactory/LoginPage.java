package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Browser;



public class LoginPage extends Browser {

	@FindBy (id = "login-email-address")
	WebElement loginEmailAddress;
	
	@FindBy (id = "login-password")
	WebElement loginPassword ;
	
	@FindBy (css = "input[value='Sign In']")
	WebElement signInButton;
	
	@FindBy (id = "gender-male")
	WebElement maleRadioButton;

	@FindBy (id = "gender-female")
	WebElement femaleRadioButton;
	
	@FindBy (id = "firstname")
	WebElement firstName;
	
	@FindBy (id = "lastname")
	WebElement lastName;
	
	@FindBy (id = "street-address")
	WebElement streetAddress;
	
	@FindBy (id = "city")
	WebElement city;
	
	@FindBy (id = "state")
	WebElement state;
	
	@FindBy (id = "postcode")
	WebElement postCode;
	
	@FindBy (id = "country")
	WebElement country;
	
	@FindBy (id = "telephone")
	WebElement telephone;
	
	@FindBy (id = "dob")
	WebElement dateOfBirth;
	
	@FindBy (id = "email-address")
	WebElement emailAddress;
	
	@FindBy (id = "password-new")
	WebElement password;
	
	@FindBy (id = "password-confirm")
	WebElement passwordConfirm;
	
	@FindBy (css = "input[value='Submit the Information']")
	WebElement submitButton;
	
	@FindBy (css = "h1#createAcctSuccessHeading")
	WebElement accountCreationConfirmation;
	
	public LoginPage(WebDriver driver){
		Browser.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void createNewUser(String gender, String fname, String lname, String address, String ci, String s, String pCode,String c, String tele, String birhtDate, String email, String pass, String passConfirm){
		
		if (gender.equalsIgnoreCase("male")){
			maleRadioButton.click();
		}
		else if (gender.equalsIgnoreCase("female")){
			femaleRadioButton.click();
		}
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		streetAddress.sendKeys(address);
		city.sendKeys(ci);
		state.sendKeys(s);
		postCode.sendKeys(pCode);
		Select drpCountry = new Select(country);
		drpCountry.selectByVisibleText(c);
		telephone.sendKeys(tele);
		dateOfBirth.sendKeys(birhtDate);
		emailAddress.sendKeys(email);
		password.sendKeys(pass);
		passwordConfirm.sendKeys(passConfirm);
	}
	
	public void submitInfo () {
		submitButton.click();
	}
	
	public String accountCreationConfirmationMessage(){
		String message = accountCreationConfirmation.getText();
		return message;
	}
	
	public void userlogin (String emailAddress, String password) {
		loginEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		signInButton.click();
	}
	
}
