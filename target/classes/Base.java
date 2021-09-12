package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public Logger log;
	
	public WebDriver intializeDriver() throws IOException 
	{
		prop=new Properties();
		String proPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		 FileInputStream fis=new FileInputStream(proPath);
		 prop.load(fis);
		 
		 String browserName=prop.getProperty("browser");
		 
		 //checking browser
		 if(browserName.equalsIgnoreCase("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		 }
		 else if(browserName.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		 }
		 else if(browserName.equalsIgnoreCase("IE"))
		 {
			 WebDriverManager.iedriver().setup();
			 driver=new InternetExplorerDriver();
		 }
		 
		 //maximizing window
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 return driver;
	}
	
    public String takeScreenshot(String testMethodName,WebDriver driver) throws IOException
    {
    	File SourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String destinationFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+testMethodName+".png";
    	FileUtils.copyFile(SourceFile,new File(destinationFilePath));
    	return destinationFilePath;
    }

}
