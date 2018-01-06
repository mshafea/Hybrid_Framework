package testcases;



import org.testng.Assert;
import utility.Constant;
import utility.ExcelUtils;
import pageFactory.HomePage;
import pageFactory.LoginPage;

//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestCreateNewUser extends ExcelUtils {

	HomePage homePageObject;
	LoginPage loginPageObject;
	Constant constantObject;
	
	
  @Test (dataProvider="NewUsers")
  public void createNewUser (String gender, String fname, String lname, String address, String ci, String s, String pCode,String c, String tele, String birhtDate, String email, String pass, String passConfirm) {
	  homePageObject = new HomePage(driver);
	  homePageObject.selectLoginPage();
	  loginPageObject = new LoginPage(driver);
	  loginPageObject.createNewUser(gender,fname,lname,address,ci, s,pCode,c,tele,birhtDate,email,pass,passConfirm);
	  loginPageObject.submitInfo();
	  Assert.assertEquals(loginPageObject.accountCreationConfirmationMessage(), "Your Account Has Been Created!", "Account created successfully");
  }
  
}
