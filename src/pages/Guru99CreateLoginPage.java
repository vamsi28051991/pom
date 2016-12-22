package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Guru99CreateLoginPage {
	WebDriver driver;
	By mrRadioBtn = By.id("id_gender1");
	By msRadioBtn = By.id("id_gender2");
	By yourFirstname = By.id("customer_firstname");
	By yourLastname = By.id("customer_lastname");
	By yourEmail = By.id("email");
	By yourPassword = By.id("passwd");
	By day = By.id("days");
	By month = By.xpath("//*[@id='months']");
	//WebElement months = driver.findElement(By.xpath("//*[@id='months']"));
	By year = By.id("years");
	//By year = By.xpath("//*[@id='years']");
	By addressFirstname = By.id("firstname");
	By addressLastname = By.id("lastname");
	By addressCompany = By.id("company");
	By addressLine1 = By.id("address1");
	By addressLine2 = By.id("address2");
	By addressCity = By.id("city");
	By addressState = By.id("id_state");
	By addressZip = By.id("postcode");
	By addressCountry = By.id("id_country");
	By additionalInfo = By.id("other");
	By homePhone = By.id("phone");
	By mobilePhone = By.id("phone_mobile");
	By myAddressAlias = By.id("alias");
	By registerBtn = By.id("submitAccount");
	
	public Guru99CreateLoginPage(WebDriver driver){
		this.driver = driver;
	}
	public void selectMrBtn(){
		driver.findElement(mrRadioBtn).click();
	}
	public void selectMrsBtn(){
		driver.findElement(msRadioBtn).click();
	}
	public void setFirstname(String strFirstname){
		driver.findElement(yourFirstname).sendKeys(strFirstname);
	}
	public void setLastname(String strLastname){
		driver.findElement(yourLastname).sendKeys(strLastname);
	}
	public void setEmail(String strEmail){
		String textEmail = driver.findElement(yourEmail).getText();
		if(textEmail.isEmpty())
		{
			driver.findElement(yourEmail).sendKeys(strEmail);
		}
	}
	public void setPassword(String strPassword){
		driver.findElement(yourPassword).sendKeys(strPassword);
	}
	public void setDaysDropdown(String strDay){
		Select dayDropdown = new Select (driver.findElement(day));
		dayDropdown.selectByValue(strDay);
		//String day1 = "//*[@id='days']/option[";
		//String day2 = "]";
		//driver.findElement(By.xpath(day1+strDay+day2)).click();
	}
	public void setMonthsDropdown(String strMonth){
		if(strMonth.substring(0, 1).equals("0")){
			String monthValue = strMonth.substring(1, 2);
			Select monthDropdown = new Select(driver.findElement(month));
			monthDropdown.selectByValue(monthValue);
		}
		else{
			Select monthDropdown = new Select(driver.findElement(month));
			monthDropdown.selectByValue(strMonth);
		}
		//List<WebElement> monthsData = driver.findElement(By.xpath("//*[@id='months']/option"));
		//for (WebElement mon:monthsData){
			//if(mon.getText().contains(strMonth)){
				//mon.click();
			//}
		//}
	}
	public void setYearsDropdown(String strYear){
		Select yearsDropdown = new Select(driver.findElement(year));
		yearsDropdown.selectByValue(strYear);
		//List<WebElement> yearsData = driver.findElement(year);
		//for (WebElement yrs:yearsData){
			//if(yrs.getText().contains(strYear)){
				//yrs.click();
			//}
		//}
	}
	public void setAddressFirstname(String strAddFirstname){
		driver.findElement(addressFirstname).clear();
		driver.findElement(addressFirstname).sendKeys(strAddFirstname);
	}
	public void setAddressLastname(String strAddLastname){
		driver.findElement(addressLastname).clear();
		driver.findElement(addressLastname).sendKeys(strAddLastname);
	}
	public void setAddressCompany(String strCompany){
		driver.findElement(addressCompany).sendKeys(strCompany);
	}
	public void setAddress1(String strAddress1){
		driver.findElement(addressLine1).sendKeys(strAddress1);
	}
	public void setAddress2(String strAddress2){
		driver.findElement(addressLine2).sendKeys(strAddress2);
	}
	public void setCity(String strCity){
		driver.findElement(addressCity).sendKeys(strCity);
	}
	public void setState(String strState){
		Select stateDropdown = new Select(driver.findElement(addressState));
		stateDropdown.selectByVisibleText(strState);
	}
	public void setZip(String strZip){
		driver.findElement(addressZip).sendKeys(strZip);
	}
	public void setCountry(String strCountry){
		Select countryDropdown = new Select(driver.findElement(addressCountry));
		countryDropdown.selectByVisibleText(strCountry);
	}
	public void setAdditionalInfo(String strAddInfo){
		driver.findElement(additionalInfo).sendKeys(strAddInfo);
	}
	public void setHomePhone(String strHome){
		driver.findElement(homePhone).sendKeys(strHome);
	}
	public void setMobilePhone(String strMobile){
		driver.findElement(mobilePhone).sendKeys(strMobile);
	}
	public void setAddressAlias(String strAlias){
		driver.findElement(myAddressAlias).clear();
		driver.findElement(myAddressAlias).sendKeys(strAlias);
	}
	public void clickRegister(){
		driver.findElement(registerBtn).click();
	}
}
