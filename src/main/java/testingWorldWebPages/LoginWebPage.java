package testingWorldWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testingWorldTestBase.BaseTest;

public class LoginWebPage extends BaseTest{
	
	public LoginWebPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id = 'tab2']/parent::li")
	WebElement loginTab;
	@FindBy(name = "_txtUserName")
	WebElement userName;
	@FindBy(name = "_txtPassword")
	WebElement password;
	@FindBy(xpath = "//input[@value = 'Login']")
	WebElement loginBtn;
	
	public void switchingToLoginTab()
	{
		loginTab.click();
	}
	
	public void enterUsername(String uName)
	{
		userName.sendKeys(uName);
	}
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	

}
