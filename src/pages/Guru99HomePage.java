package pages;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99HomePage {
	
	WebDriver driver;
	
	//By homePageUserName =  By.className("heading3");
	//By homePageUserName = By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
	By homePageLogin = By.className("login");
	
	public Guru99HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void getHomePageUsername(){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//return driver.findElement(homePageUserName).getText();
		driver.findElement(homePageLogin).click();
	}
	
	public void quitDriver(){
		driver.quit();
	}
}
