package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactory.CheckoutSuccessPage;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import pageFactory.OrderConfirmationPage;
import pageFactory.PaymentInformation;
import pageFactory.ShoppingCart;
import pageFactory.SoftwarePage;
import utility.ExcelUtils;

public class Purchasing extends ExcelUtils {
	HomePage homePageObject;
	SoftwarePage softwareObject;
	ShoppingCart shoppingCartObject;
	LoginPage loginOject;
	PaymentInformation paymentInfoObject;
	OrderConfirmationPage orderConfirmationObject;
	CheckoutSuccessPage checkoutSuccessObject;
	
  @Test (dataProvider="loginUsers")
  public void purcharseOrder(String email, String pass) {
	  homePageObject = new HomePage(driver);
	  softwareObject = new SoftwarePage(driver);
	  shoppingCartObject = new ShoppingCart(driver);
	  loginOject = new LoginPage(driver);
	  paymentInfoObject = new PaymentInformation(driver);
	  orderConfirmationObject = new OrderConfirmationPage(driver);
	  checkoutSuccessObject = new CheckoutSuccessPage(driver);
	  
	  homePageObject.selectSoftware();
	  softwareObject.unrealTournamentSelection();
	  softwareObject.addToCartPress();
	  shoppingCartObject.checkoutPress();
	  loginOject.userlogin(email, pass);
	  paymentInfoObject.orderCommentsFilling();
	  paymentInfoObject.continuePress();
	  orderConfirmationObject.confirmOrderPress();
	  Assert.assertEquals(checkoutSuccessObject.getCheckoutSuccessHeading(), "Thank You! We Appreciate your Business!", "Order is done successfully"); 
	  
  }
}
