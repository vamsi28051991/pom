package Test;

import org.testng.TestNG;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.excelProgram;
import pages.Guru99CreateLoginPage;
import pages.Guru99HomePage;
import pages.Guru99LoginPage;

public class TestGuru99CreateAccount {
	
	WebDriver driver;
	Guru99HomePage objHome;
	Guru99LoginPage objLogin;
	Guru99CreateLoginPage objCreateLogin;
	
	@BeforeTest(alwaysRun=true)
	public void setup() throws IOException{
		//int rowCount = excelProgram.getExcelRowCount("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test(priority=0)
	public void clickLoginOnHomePage(){
		objHome = new Guru99HomePage(driver);
		objHome.getHomePageUsername();
	}
	@Test(priority=1)
	public void clickCreateAccount() throws InterruptedException, IOException{
		objLogin = new Guru99LoginPage(driver);
		//String createEmail = excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 0);
		objLogin.createAccount(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 0));
	}
	@Test(priority=2)
	public void clickRegister() throws InterruptedException, IOException{
		objCreateLogin = new Guru99CreateLoginPage(driver);
		String mrRadioBtn = excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 1);
		if(mrRadioBtn.equals("Yes")){
			objCreateLogin.selectMrBtn();
		}
		else{
			objCreateLogin.selectMrsBtn();
		}
		objCreateLogin.setFirstname(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 2));
		objCreateLogin.setLastname(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 3));
		//objCreateLogin.setEmail("abcd1209002@gmail.com");
		//String Password = excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 0, 1);
		objCreateLogin.setPassword(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 4));
		//String day = excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 5);
		objCreateLogin.setDaysDropdown(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 5));
		objCreateLogin.setMonthsDropdown(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 6));
		objCreateLogin.setYearsDropdown(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 7));
		objCreateLogin.setAddressFirstname(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 2));
		objCreateLogin.setAddressLastname(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 3));
		objCreateLogin.setAddressCompany(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 8));
		objCreateLogin.setAddress1(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 9));
		objCreateLogin.setAddress2(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 10));
		objCreateLogin.setCity(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 11));
		objCreateLogin.setState(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 12));
		objCreateLogin.setZip(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 13));
		objCreateLogin.setCountry(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 14));
		objCreateLogin.setAdditionalInfo(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 15));
		objCreateLogin.setHomePhone(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 16));
		objCreateLogin.setMobilePhone(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 17));
		objCreateLogin.setAddressAlias(excelProgram.getExcelStringData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 18));
		Thread.sleep(20000);
		objCreateLogin.clickRegister();
		Thread.sleep(5000);
		driver.quit();
		excelProgram.setExcelData("C:\\Users\\vthond001c\\Desktop\\TestData.xlsx", "TestSheet", 1, 19,"Account Created");				
	}
}
