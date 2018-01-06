package setup;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utility.Browser;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestBase extends Browser  {

  @BeforeTest
  
  @Parameters("browser")
	public void setUp(String browser) {
		try {

			String Homeurl = getUrlFromProperty();
			
			if (browser.equalsIgnoreCase("Firefox")) {

				startBrowser(browser);
				goTo(Homeurl);

			} else if (browser.equalsIgnoreCase("Chrome")) {
				startBrowser(browser);
				goTo(Homeurl);
				
			} else if (browser.equalsIgnoreCase("IE")) {
				startBrowser(browser);
				goTo(Homeurl);
			}
			
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}

	}

  @AfterMethod 
  public void failedTestCases(ITestResult result){
	  if (ITestResult.FAILURE==result.getStatus()){
		  takesnapshot(driver, result.getName());
	  }
	  
  }
  
  @AfterTest
  public void teardown(){
	  //driver.close();
	  //sendmailByGMail("mohshafea@gmail.com", "", "mshafea@integrant.com", "Test Email", "");
	  driver.quit();
  }
}
