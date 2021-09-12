package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
WebDriver driver;
	
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);

}
	
	@FindBy(id="input-email")
	@CacheLookup
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	@CacheLookup
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	private WebElement loginButton;
	
	

	public WebElement emailAddressField()
	{
		return emailAddressField;
	}
	
	public WebElement passwordField()
	{
		return passwordField;
	}
	
	public WebElement loginButton()
	{
		return loginButton;
	}
	
}
