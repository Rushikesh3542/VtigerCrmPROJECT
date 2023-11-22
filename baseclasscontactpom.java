package commonUtilss;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import POM.ContactPage;
import POM.LoginPage;

public class baseclasscontactpom {
	public	WebDriver d;
	propertyFileUtils futils=new propertyFileUtils();
	WebDriverUtils wutils=new WebDriverUtils();
	ExcelUtils eutils=new ExcelUtils();
	javaUtils jutils=new javaUtils();
	ContactPage con=new ContactPage();

	@BeforeSuite
public void bsConfig() {
	Reporter.log("--connect to data base--->");
}
@BeforeClass
public void lunchBrowser() throws IOException {
	String BROWSER=futils.getDataFromPropertyfile("browser");
	String URL=futils.getDataFromPropertyfile("url");
	if (BROWSER.equalsIgnoreCase("Chrome")) {
		d=new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("Edge")) {
		d=new EdgeDriver();
	} 
	else
	{
		d=new FirefoxDriver();
	}
	d.get(URL);
	wutils.maximize(d);
	wutils.implicitwait(d);
	
}
@BeforeMethod
public void bmconfig() throws IOException {
	String USERNAME=futils.getDataFromPropertyfile("username");
	String PASSWORD=futils.getDataFromPropertyfile("password");
	
	LoginPage lp=new LoginPage();
	PageFactory.initElements(d, lp);
	lp.getUsernametf().sendKeys(USERNAME);
	lp.getPasswordtf().sendKeys(PASSWORD);
	lp.getSubmitbtn().click();
	
	
}
@AfterMethod
public void amconfig() {
	PageFactory.initElements(d, con);
	wutils.action(d, con.getImagebtn());
	con.getSignoutbtn().click();
	
}
@AfterClass
public void  acconfig() {
	d.close();
	
}
@AfterSuite
public void asConfig() {
	Reporter.log("<disconnect the data>.");
}
}
