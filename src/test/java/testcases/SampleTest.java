package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class SampleTest extends Base  {

	public WebDriver driver;
@Test
public void Sample() throws IOException, InterruptedException
{
	System.out.println("this is Sample Test");
    Thread.sleep(2000);
	Assert.assertTrue(false);
}
@BeforeMethod
public void openApplication() throws IOException
{
	 log=LogManager.getLogger(Base.class.getName());
	 driver=intializeDriver();
	 log.debug("Navigating to Application");
	 driver.get("http://demowebshop.tricentis.com/");
}

@AfterMethod
public void CloseBrowser()
{
	log.debug("Close an Application");
	driver.close();
}
}
