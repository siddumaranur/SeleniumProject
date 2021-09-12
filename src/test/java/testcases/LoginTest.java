package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	
   
	@Test(dataProvider="getLoginData")
	public void login(String email,String Pwd,String ExpectedResult) throws InterruptedException 
	{
		
		
		LandingPage landingpage=new LandingPage(driver);
		
		landingpage.myAccountDropdown().click();
		log.debug("Click on My Account");
		log.debug("click on Login option");
		landingpage.loginOption().click();
		
		Thread.sleep(3000);
		LoginPage loginpage=new LoginPage(driver);
		//loginpage.emailAddressField().sendKeys(prop.getProperty("email"));
	//	loginpage.passwordField().sendKeys(prop.getProperty("password"));
		
		log.debug("Enter Emalid");
		loginpage.emailAddressField().sendKeys(email);
		log.debug("Enter Password");
		loginpage.passwordField().sendKeys(Pwd);
		log.debug("Click on Login Button");
		loginpage.loginButton().click();
		
		Thread.sleep(3000);
		String title=driver.getTitle();
		log.debug("Verifying Test Result");
		if(title.equals("My Account"))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test Failed");
		}
		
		AccountPage ac=new AccountPage(driver);
		String ActualResult=null;
		try
		{
			
			if(ac.editAccountlink().isDisplayed())
			{
			ActualResult="Success";
			}
		}
		catch(Exception e)
		{
			
			ActualResult="Failure";
		}
		Assert.assertEquals(ActualResult, ExpectedResult);
		
	}
	

	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data= {{"siddumaranur371@gmail.com","Siddu999","Success"}};
		return data;
	}
		
	@BeforeMethod
	public void openApplication() throws IOException
	{
		 log=LogManager.getLogger(Base.class.getName());
		 driver=intializeDriver();
		 log.debug("Navigating to Application");
		 driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		log.debug("Close an Application");
		driver.close();
	}

}
