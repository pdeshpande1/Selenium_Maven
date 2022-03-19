package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginFailureTest extends BaseClass{
	
	
	//WebDriver driver=BaseClass.driver;
	LoginPage loginpage= new LoginPage();

	
	/*public void LoginFailedTest()
	{
		
		loginpage.LoginFunction("xyz@abc.com","Abc@12345");
	
		WebElement ErrorMsg = driver.findElement(By.xpath("//div[@id='msg_box']")); 
		//WebDriverWait wait=new WebDriverWait(driver,50);
		//wait.until(ExpectedConditions.textToBe(By.className("//div[@id='msg_box']"), "The email or password you have entered is invalid."));
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links are " + links.size());
		
		for(WebElement elm : links) {
			
			System.out.println(elm.getAttribute("href"));
		}	
	}*/
	
	
	/*@Parameters({"Param1", "Param2"})
	public void ParameterizedTest(String UserNameval, String Passwordval)
	{
		loginpage.LoginFunction( UserNameval,  Passwordval);
	}*/
	
	/*@Test
	public void LoginSuccessTest()
	{
		
		loginpage.LoginFunction("prachi.deshpande11@gmail.com", "August@1220");
		WebElement Actual_text= driver.findElement(By.className("//li[@class='ng-star-inserted']/a"));
		String verify_Text=Actual_text.getText();
		String expected_Text="My Courses";
		
		Assert.assertEquals(verify_Text, expected_Text);
	}*/
	
	@Test
	public void ExternalData()
	{
		String username=worksheet.getRow(1).getCell(0).getStringCellValue();
		String password=worksheet.getRow(1).getCell(1).getStringCellValue();
		loginpage.LoginFunction(username, password);
		WebElement ErrorMsg = driver.findElement(By.xpath("//div[@id='msg_box']")); 
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
	}
	
	
	
}
	
	
	



