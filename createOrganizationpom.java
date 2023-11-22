package base;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import POM.ConHomePage;
import POM.ContactPage;
import POM.LoginPage;
import POM.orgHomePage;
import POM.orgpage;
import commonUtilss.Baseclass;
import commonUtilss.ExcelUtils;
import commonUtilss.WebDriverUtils;
import commonUtilss.baseclassorganizationpom;
import commonUtilss.javaUtils;
import commonUtilss.propertyFileUtils;

public class createOrganizationpom extends baseclassorganizationpom {
	@Test
	public void organzitionpom() throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		propertyFileUtils futils=new propertyFileUtils();
		WebDriverUtils wutils=new WebDriverUtils();
		ExcelUtils eutils=new ExcelUtils();
		javaUtils jutils=new javaUtils();
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);	
		
		String Firstname = eutils.getDataFromExcelFile("Sheet1", 1, 3);
	    String Lastname = eutils.getDataFromExcelFile("Sheet1", 1, 4);
	    String ASSIGNED = eutils.getDataFromExcelFile("Sheet1", 2, 1);
	    String PARENTURL=eutils.getDataFromExcelFile("Sheet1", 1, 7);
	     String CHILDURL=eutils.getDataFromExcelFile("Sheet1", 1, 8);
	
		orgHomePage cp=new orgHomePage();
		PageFactory.initElements(d, cp);
		cp.getorgbtn().click();
		cp.getImagebtn().click();
		
		orgpage con=new orgpage();
		PageFactory.initElements(d, con);
		con.getNametf().sendKeys(OrgName+jutils.getRandomNumber());
		
		
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
		d.switchTo().alert().dismiss();
		Thread.sleep(5000);
		wutils.switchtowindow(d, PARENTURL);
		wutils.scrrenshot(d);
//		d.switchTo().alert().accept();
		wutils.scrolling(d);
//			con.getSavebtn().click();
		wutils.action(d, con.getImagebtn());
		con.getSignoutbtn().click();
		
	
}

	}


