package Framework;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import commonUtilss.Baseclass;
import commonUtilss.ExcelUtils;
import commonUtilss.WebDriverUtils;
import commonUtilss.javaUtils;
import commonUtilss.propertyFileUtils;

public class organizationField extends Baseclass {
	 
	@Test
	public void organzation() throws EncryptedDocumentException, IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		propertyFileUtils futils=new propertyFileUtils();
		WebDriverUtils wutils=new WebDriverUtils();
				ExcelUtils eutils=new ExcelUtils();
	           javaUtils jutils=new javaUtils();
//		
//		String BROWSER = futils.getDataFromPropertyfile("browser");
//		String URL = futils.getDataFromPropertyfile("url");
//		String USERNAME = futils.getDataFromPropertyfile("username");
//		String PASSWORD = futils.getDataFromPropertyfile("password");
//		

//		if (BROWSER.equalsIgnoreCase("Chrome")) {
//			d=new ChromeDriver();
//		}
//		else if (BROWSER.equalsIgnoreCase("Edge")) {
//			d=new EdgeDriver();
//		}
//		else
//		{
//			d=new FirefoxDriver();
//		}
////		maximize the window
//		wutils.maximize(d);
////		to apply implicitwait
//	    wutils.implicitwait(d);	
////	    lanuch url
//		d.get(URL);
////		login to application
//		d.findElement(By.name("user_name")).sendKeys(USERNAME);
//		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		d.findElement(By.id("submitButton")).click();
		d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		d.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String OrgName=eutils.getDataFromExcelFile("Sheet1", 0, 0);
	    String ASSIGNED = eutils.getDataFromExcelFile("Sheet1", 2, 1);
	     String PARENTURL=eutils.getDataFromExcelFile("Sheet1", 1, 7);
	     String CHILDURL=eutils.getDataFromExcelFile("Sheet1", 2, 8);
	     d.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName+jutils.getRandomNumber());
	     
	     
	     d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	     WebElement dropdown = d.findElement(By.name("assigned_group_id"));
//	     dropdown element
	     wutils.handledropdown(dropdown, ASSIGNED);
	   //  clcik on 
	 	d.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();	
	 	//to transfer control from parent to child
	 	wutils.switchtowindow(d,CHILDURL)	;
	 	d.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("roogger");
	 	d.findElement(By.name("search")).click();
	 	d.findElement(By.xpath("//a[text()='roogger']")).click();
	 	Thread.sleep(1000);
	    d.switchTo().alert().dismiss();
	 	Thread.sleep(4000);
	 	
	 	//to transfer control from child to parent	
	 	wutils.switchtowindow(d, PARENTURL);
	 	
	 	
	 	//take a screenshot webpage
	 	wutils.scrrenshot(d);
	 
//	 	 scrolling operation
	 	 wutils.scrolling(d);
	 	 
	    	d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	 	 //click on admin image
//	 	d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
//	 		    WebElement image = d.findElement(By.xpath("(//td[@class='small'])[2]"));
//	 		   Actions a=new Actions(d);
//	 		   a.moveToElement(image).perform();
//	 		   d.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
