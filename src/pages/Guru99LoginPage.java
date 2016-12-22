package pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Guru99LoginPage {
	
	WebDriver driver;
	
	By createEmailText = By.id("email_create");
	By createButton = By.id("SubmitCreate");
	By signinEmailText = By.id("email");
	By signinPasswordText = By.id("passwd");
	By signinButton = By.id("SubmitLogin");
	By accountAlreadyExists = By.xpath(".//*[@id='create_account_error']/ol/li");
	By accountError = By.className("page-subheading");

	public Guru99LoginPage(WebDriver driver){
		this.driver = driver;
	}

	public void setUserName(String strUserName){
		driver.findElement(signinEmailText).sendKeys(strUserName);
	}
	public void setPassword(String strPassword){
		driver.findElement(signinPasswordText).sendKeys(strPassword);
	}
	public void clickSignin(){
		driver.findElement(signinButton).click();
	}
	//public String getLoginTitle(){
		//return driver.findElement(Guru99Title).getText();
	//}
	public void setCreateEmail(String strCreateEmail){
		driver.findElement(createEmailText).sendKeys(strCreateEmail);
	}
	public void clickCreateAccount(){
		driver.findElement(createButton).click();
	}
	
	public void loginToGuru99(String strUserName, String strPassword) throws InterruptedException{
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.clickSignin();
	}
	public void createAccount(String strCreateEmail) throws InterruptedException, IOException{
		this.setCreateEmail(strCreateEmail);
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.clickCreateAccount();
		Thread.sleep(5000);
		String strTitle = driver.findElement(accountError).getText();
		System.out.println(strTitle);
		if(strTitle.equals("CREATE AN ACCOUNT")){
			checkForError();
		}
		else
			System.out.println("Proceeding to register");
	}
	public void checkForError() throws IOException{
		String strAccAlreadyExists = driver.findElement(accountAlreadyExists).getText();
		if(strAccAlreadyExists.equals("An account using this email address has already been registered. Please enter a valid password or request a new one.")){
			captureScreenShot(driver, "createAccountError_");
			driver.quit();
		}
	}
	public void captureScreenShot(WebDriver driver, String strLogin) throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\vthond001c\\Downloads\\Selenium_Screenshots\\"+strLogin+System.currentTimeMillis()+".png"));
	}
}

