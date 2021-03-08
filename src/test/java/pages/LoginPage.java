package pages;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Driver {
    @FindBy(css="[name='commit']")
    private WebElement loginbtn;

    @FindBy(css="[type='email']")
    private WebElement loginEmail;

    @FindBy(css="[type='password']")
    private WebElement loginPassword;

    public LoginPage(WebDriver driver)
    {
       this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void setUserName()
    {
        loginEmail.sendKeys("sample@yahoo.com");
    }
    public void setLoginPassword()
    {
        loginPassword.sendKeys("pwd123");
    }
    public void clickLogInButton()
    {
        loginbtn.click();
    }

}
