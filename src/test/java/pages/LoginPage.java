package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	
	 WebDriver driver=BaseClass.driver;
	 //ExtentTest test= BaseClass.test;
	LoginPage loginpage;
	 
	 
	 
	// ===================WebEleemnts===============================
	 @FindBy(className="login")
	 WebElement LoginLink;
	 
	 @FindBy(name="user_login")
	 WebElement UserName;
	 
	 @FindBy(id="password")
	 WebElement Password;
	 
	 @FindBy(name="btn_login")
	 WebElement LoginBtn;
	 
	 @FindBy(className="rememberMe")
	 WebElement RememberMe;
	 
	 public  LoginPage()
	 {
		 PageFactory.initElements(driver,this);
		 
		 
	 }
	 
	//========================Functions================================= 
	


	public void LoginFunction(String UserNameval,String Passwordval)
	{
		ExtentTest test= BaseClass.test;
		//WebElement LoginLink = driver.findElement(By.className("login")); //a[@class='login']
		LoginLink.click();
		System.out.println("Login button is clicked");
		
		test.log(LogStatus.PASS, "Click on Login Link", "Login Link clicked successfully");
		test.log(LogStatus.PASS, "Click on Login Link", "Login Link clicked successfully");
		
		//driver.manage().timeouts().implicitlyWait(, null)
		// As a good practise it is advisable to create object and instantiate it. That object can be used anywhere in the script
		//driver.findElement(By.className("login")).click();
				//driver.findElement(By.id(""))
		
		/*WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement RememberMe= driver.findElement(By.className("rememberMe")); */
		
		UserName.sendKeys("xyz@abc.com");
		test.log(LogStatus.PASS, "Enter UserName", "UserName entered successfully");
		Password.sendKeys("Abc@12345");
		test.log(LogStatus.PASS, "Enter password", "Password enetered successfully");
		RememberMe.click();
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login button", "Login Link button clicked successfully");
		
	}

}
