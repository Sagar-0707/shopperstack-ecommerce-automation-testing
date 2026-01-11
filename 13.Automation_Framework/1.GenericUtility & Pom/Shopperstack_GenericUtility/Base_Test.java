package com.Shopperstack_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Shopperstack_Pom.Home_page;
import com.Shopperstack_Pom.Login_page;
import com.Shopperstack_Pom.Welcome_page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test 
{
	public  WebDriver driver;
	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public File_Utility fileUtility = new File_Utility();
    
	public Welcome_page welcomepage;
	public Login_page loginPage;
	public WebDriverWait wait;
	public Home_page homePage;
	
	public Webdriver_Utility webDriverUtility=new Webdriver_Utility();
	
	
	
	@BeforeSuite
    public void beforeSuite()
    {
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() 
    {
        System.out.println("BeforeTest");
        spark = new ExtentSparkReporter(FrameWorkConstants.reportsPath);
        reports = new ExtentReports();
        reports.attachReporter(spark);
        test = reports.createTest("Demo");
    }    

    @BeforeClass
    public void beforeClass() throws IOException
    {
        System.out.println("BeforeClass");
        
       String browser = fileUtility.readDataFromPropertyFile("browserName");     
       String url = fileUtility.readDataFromPropertyFile("url");
       
//        //for parameter (by using ouside run the script using CMD)
//         
//       String browser= System.getProperty("browserName");
//       String  url= System.getProperty("url");
        

        if (browser.contains("chrome")) 
        {
            driver = new ChromeDriver();
        }
        else if (browser.contains("edge"))
        {
            driver = new EdgeDriver();
        }
        else if (browser.contains("firefox"))
        {
            driver = new FirefoxDriver(); 
        }
        else 
        {
            System.out.println("Please enter a valid Browser Name");
            return;
        }

        sDriver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
    }

    @BeforeMethod
    
    public void beforeMethod() throws IOException, InterruptedException  
    {
        System.out.println("BeforeMethod");    

        welcomepage = new Welcome_page(driver);
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(14));
        wait.until(ExpectedConditions.elementToBeClickable(welcomepage.getLoginBtn()));
        Thread.sleep(3000);

        welcomepage.getLoginBtn().click();
        
        loginPage = new Login_page(driver);
        
        loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
        loginPage.getPasswordtextfield().sendKeys(fileUtility.readDataFromPropertyFile("password"));
        loginPage.getLoginBtn().click();

       
        homePage = new Home_page(driver);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException
    {
        System.out.println("AfterMethod");

        homePage.getAccountSettingBtn().click();
        Thread.sleep(2000);
        homePage.getLogOutBtn().click();
    }

    @AfterClass
    public void afterClass() throws InterruptedException 
    {
        System.out.println("AfterClass");
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("AfterTest");
        
        reports.flush();
    }
}
