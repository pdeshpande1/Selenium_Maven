package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import jdk.internal.org.objectweb.asm.commons.Method;

public class BaseClass {
	
public static WebDriver driver=new ChromeDriver();

XSSFWorkbook workbook;
XSSFSheet worksheet;
public static ExtentReports report;
public static ExtentTest test;

	@BeforeTest
	public void DataSetup() throws IOException
	{
		FileInputStream fis= new FileInputStream("exceldata.xlsx");
		workbook=new XSSFWorkbook(fis);
		worksheet= workbook.getSheet("Sheet1");
		
		report= new ExtentReports("Extentreport.html");
		
	
	}
	
	@BeforeMethod
	public void SetUp(Method method)
	{
		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		//this.driver=new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("login")));
		
		//WebDriver driver= new FirefoxDriver();
		System.out.println("wait is over");
		
	}
	
	@AfterMethod
	public void closebrowser()
	{
		report.endTest(test);
		driver.close();
	}
	
	@AfterTest
	public void TearDown() throws IOException
	{
		workbook.close();
		report.flush();
		report.close();
	
	}
		

}
