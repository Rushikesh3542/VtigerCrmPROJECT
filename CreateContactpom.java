package base;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import POM.ConHomePage;
import POM.ContactPage;
import POM.LoginPage;
import commonUtilss.ExcelUtils;
import commonUtilss.WebDriverUtils;
import commonUtilss.baseclasscontactpom;
import commonUtilss.propertyFileUtils;

public class CreateContactpom extends baseclasscontactpom {
	@Test
	public void contactpom() throws IOException, InterruptedException {
		
		
		propertyFileUtils futils=new propertyFileUtils();
		WebDriverUtils wutils=new WebDriverUtils();
		ExcelUtils eutils=new ExcelUtils();
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);	
		
		String Firstname = eutils.getDataFromExcelFile("Sheet1", 1, 3);
	    String Lastname = eutils.getDataFromExcelFile("Sheet1", 1, 4);
	    String ASSIGNED = eutils.getDataFromExcelFile("Sheet1", 2, 1);
	    String PARENTURL=eutils.getDataFromExcelFile("Sheet1", 1, 7);
	     String CHILDURL=eutils.getDataFromExcelFile("Sheet1", 1, 8);
		
		ConHomePage cp=new ConHomePage();
		PageFactory.initElements(d, cp);
		cp.getContactbtn().click();
		cp.getImagebtn().click();
		
		ContactPage con=new ContactPage();
		PageFactory.initElements(d, con);
		con.getFirstnametf().sendKeys(Firstname);
		con.getLastnametf().sendKeys(Lastname);
		
		con.getAssignedtotf().click();
		wutils.handledropdown(con.getAssignedtobtn(),ASSIGNED);
		
		con.getContactplusbtn().click();
		Set<String> ids = d.getWindowHandles();
		System.out.println(ids);
		wutils.switchtowindow(d, CHILDURL);
		for (String allids : ids) {
			d.switchTo().window(allids).getTitle();
		}
		con.getSearchbtn().sendKeys(OrgName);
		con.getSearchingbtn().click();
		con.getContacttext().click();
		Thread.sleep(2000);
		wutils.switchtowindow(d, PARENTURL);
		wutils.scrrenshot(d);
		 Thread.sleep(2000);
		wutils.scrolling(d);
			con.getSavebtn().click();
		
	
}
}