package pages;

import general.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(css="[name='commit']")
    private WebElement loginbtn;

    @FindBy(css="[type='email']")
    private WebElement loginEmail;

    @FindBy(css="[type='password']")
    private WebElement loginPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String pwd)
    {
        loginEmail.sendKeys(username);
        loginPassword.sendKeys(pwd);
        loginbtn.click();
    }

}
