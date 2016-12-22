package Test;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Guru99HomePage;
import pages.Guru99LoginPage;

public class TestGuru99Login {

	WebDriver driver;
	Guru99LoginPage objLogin;
	Guru99HomePage objHome;
	
	@BeforeTest
	public void setup(){
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test(priority=0)
	public void clickLoginOnHomePage() throws InterruptedException{
		objHome = new Guru99HomePage(driver);
		objHome.getHomePageUsername();
		//objLogin = new Guru99LoginPage(driver);
		//String LoginPageTitle = objLogin.getLoginTitle();
		//System.out.println("Login Page Title" + LoginPageTitle);
		//Assert.assertTrue(LoginPageTitle.contains("Guru99 Bank"));
		//objLogin.loginToGuru99("mngr56179", "rUdAbYb");
		//objHome = new Guru99HomePage(driver);
		//String HomePageTitle = objHome.getHomePageUsername();
		//Assert.assertTrue(HomePageTitle.contains("Manger Id : mngr56179"));
		Thread.sleep(50000);
		//driver.quit();
		//objHome.quitDriver();
	}
	@Test(priority=1)
	public void clickLoginInLoginPage() throws InterruptedException{
		objLogin = new Guru99LoginPage(driver);
		objLogin.loginToGuru99("abc@test.com", "Test123");
	}
}
