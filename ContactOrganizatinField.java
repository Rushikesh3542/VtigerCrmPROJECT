package Framework;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonUtilss.ExcelUtils;
import commonUtilss.WebDriverUtils;
import commonUtilss.baseclasscontact;
import commonUtilss.propertyFileUtils;

public class ContactOrganizatinField  extends baseclasscontact{
	@Test
public void contact() throws IOException, InterruptedException {
	
	propertyFileUtils futils=new propertyFileUtils();
	WebDriverUtils wutils=new WebDriverUtils();
	ExcelUtils eutils=new ExcelUtils();
	
//	String BROWSER = futils.getDataFromPropertyfile("browser");
//	String URL = futils.getDataFromPropertyfile("url");
//	String USERNAME = futils.getDataFromPropertyfile("username");
//	String PASSWORD = futils.getDataFromPropertyfile("password");
//	

//	if (BROWSER.equalsIgnoreCase("Chrome")) {
//		d=new ChromeDriver();
//	}
//	else if (BROWSER.equalsIgnoreCase("Edge")) {
//		d=new EdgeDriver();
//	}
//	else
//	{
//		d=new FirefoxDriver();
//	}
////	maximize the window
//	wutils.maximize(d);
////	to apply implicitwait
//    wutils.implicitwait(d);	
////    lanuch url
//	d.get(URL);
//	login to application
//	d.findElement(By.name("user_name")).sendKeys(USERNAME);
//	d.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	d.findElement(By.id("submitButton")).click();
//	  click on contact
	d.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
	Reporter.log("<--click on contact>--");
//	click on contact plus button
	d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	Reporter.log("<--enter data from sheet on contact>--");
	String Firstname = eutils.getDataFromExcelFile("Sheet1", 1, 3);
    String Lastname = eutils.getDataFromExcelFile("Sheet1", 1, 4);
    String ASSIGNED = eutils.getDataFromExcelFile("Sheet1", 2, 1);
     String PARENTURL=eutils.getDataFromExcelFile("Sheet1", 1, 7);
     String CHILDURL=eutils.getDataFromExcelFile("Sheet1", 1, 8);
//    to enter firdt name
     Reporter.log("<enter first name of contact module >--");
    d.findElement(By.name("firstname")).sendKeys(Firstname);
       Reporter.log("<--enter last name of contact module >--");
    d.findElement(By.name("lastname")).sendKeys(Lastname);
    Reporter.log("<--click on radio button >--");
    d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
    WebElement dropdown = d.findElement(By.name("assigned_group_id"));
    Reporter.log("<--click on dropdown  >--");
    wutils.handledropdown(dropdown, ASSIGNED);
//    clcik on 
	d.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();	
	 Reporter.log("<--parent to child  >--");
	wutils.switchtowindow(d,CHILDURL)	;
	d.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("pune");
	d.findElement(By.name("search")).click();
	d.findElement(By.xpath("//a[text()='Pune']")).click();
	Thread.sleep(4000);
	
	//to transfer control from child to parent	
	wutils.switchtowindow(d, PARENTURL);
	
 Reporter.log("<--take a scrrenshot of webpage >--");
	wutils.scrrenshot(d);
	 
	 Thread.sleep(2000);
	 Reporter.log("<--scrolling operation>--");
	 wutils.scrolling(d);
//	d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
//		    
//		    WebElement image = d.findElement(By.xpath("(//td[@class='small'])[2]"));
//		   Actions a=new Actions(d);
//		   a.moveToElement(image).perform();
//		   d.findElement(By.xpath("//a[text()='Sign Out']")).click();

		
		
	}
	
}