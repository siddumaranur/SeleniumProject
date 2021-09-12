package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class Login extends Base {
	
	  WebDriver driver;
	  LandingPage landingpage;
	  LoginPage loginpage;
	  AccountPage ac;
	 @Given("^Open any Browser$")
	    public void open_any_browser() throws IOException 
	   {
		 driver=intializeDriver();
	  
	    }

	    @And("^Navigate Login Page$")
	    public void navigate_login_page() throws InterruptedException  {
	    	driver.get(prop.getProperty("url"));
	    	 landingpage=new LandingPage(driver);
	    	landingpage.myAccountDropdown().click();
	    	landingpage.loginOption().click();
			Thread.sleep(3000);
			
			
	    }
	    
	    @When("^use enter username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	    public void use_enter_username_as_something_and_password_as_something(String email, String password)  {
	        loginpage=new LoginPage(driver);
	    	loginpage.emailAddressField().sendKeys(email);
			loginpage.passwordField().sendKeys(password);
			
	    }

	    @And("^user click on Login Button$")
	    public void user_click_on_login_button()  {
	    	loginpage.loginButton().click();
	    }

	    @Then("^Verify user is able to successfully Login$")
	    public void verify_user_is_able_to_successfully_login()  {
	    	ac=new AccountPage(driver);
	    	boolean val=ac.editAccountlink().isDisplayed();
	      Assert.assertTrue(val);;
	    }
	    
	    @After
	    public void CloseBrowser()
	    {
	    	driver.close();
	    }
}
