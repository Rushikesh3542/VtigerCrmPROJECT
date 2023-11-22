package commonUtilss;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Baseclass {
public	WebDriver d;
	propertyFileUtils futils=new propertyFileUtils();
	WebDriverUtils wutils=new WebDriverUtils();
	ExcelUtils eutils=new ExcelUtils();
	javaUtils jutils=new javaUtils();

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
public void bmConfigu() throws IOException {
	String USERNAME=futils.getDataFromPropertyfile("username");
	String PASSWORD=futils.getDataFromPropertyfile("password");
	d.findElement(By.name("user_name")).sendKeys(USERNAME);
	d.findElement(By.name("user_password")).sendKeys(PASSWORD);
	d.findElement(By.id("submitButton")).click();
}
@AfterMethod
public void AmConfigu() throws IOException{
	WebElement image = d.findElement(By.xpath("(//td[@class='small'])[2]"));
	   Actions a=new Actions(d);
	   a.moveToElement(image).perform();
	   d.findElement(By.xpath("//a[text()='Sign Out']")).click();

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
