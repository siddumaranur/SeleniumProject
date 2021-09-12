package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	 WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath="//span[contains(text(),'My Account')]")
	@CacheLookup
	private WebElement myAccountDropdown;
	
	@FindBy(linkText="Login")
	@CacheLookup
	private WebElement loginOption;
	
	
	public WebElement myAccountDropdown()
	{
		return myAccountDropdown;
	}
	
	public WebElement loginOption()
	{
		return loginOption;
	}

}
